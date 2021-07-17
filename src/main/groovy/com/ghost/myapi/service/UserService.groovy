package com.ghost.myapi.service

import com.ghost.myapi.enums.MetaResponse
import com.ghost.myapi.enums.RoleAuthority
import com.ghost.myapi.enums.UserStatus
import com.ghost.myapi.enums.UserType
import com.ghost.myapi.io.request.AdminRequest
import com.ghost.myapi.io.response.Meta
import com.ghost.myapi.io.response.ResultData
import com.ghost.myapi.io.response.data.UserResponse
import com.ghost.myapi.model.entity.Role
import com.ghost.myapi.model.entity.User
import com.ghost.myapi.repository.OauthAccessTokenRepository
import com.ghost.myapi.repository.OauthClientDetailsRepository
import com.ghost.myapi.repository.RoleRepository
import com.ghost.myapi.repository.UserRepository
import com.ghost.myapi.utility.Helper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

import javax.transaction.Transactional

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-15.
 **/

@Service
class UserService implements UserDetailsService {

    @Value('${assets.static.path}')
    String staticPath

    @Value('${assets.url}')
    String assetsUrl

    @Value('${user.images.path}')
    String userImagesPath

    @Autowired
    UserRepository userRepository

    @Autowired
    OauthClientDetailsService clientDetailsService

    @Autowired
    PasswordEncoder userPasswordEncoder

    @Autowired
    RoleRepository roleRepository

    @Autowired
    OauthClientDetailsRepository clientDetailsRepository

    @Autowired
    OauthAccessTokenRepository accessTokenRepository

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameAndStatus(username, UserStatus.ACTIVE)
                .orElseThrow({ throw new UsernameNotFoundException("User not found!")} )

        return (UserDetails) new org.springframework.security.core.userdetails.User(user.username, user.password, user.getRoles() as Collection<? extends GrantedAuthority>)
    }

    ResponseEntity listAdmin(Pageable pageable) {
        Page<User> admins = userRepository.findAllByUserTypeAndStatus(pageable, UserType.ADMIN, UserStatus.ACTIVE)
        List<UserResponse> responses = new ArrayList<>()
        admins.each {
            responses.add(new UserResponse(it, ""))
        }
        return ResponseEntity.ok(new ResultData(
                meta: new Meta(MetaResponse.SUCCESS),
                data: Helper.pageToResponse(admins, responses)
        ))
    }

    @Transactional
    ResponseEntity saveAdmin(AdminRequest request) {
        Boolean usernameExists = userRepository.existsByUsernameAndStatusNot(request.username, UserStatus.DELETED)
        if (usernameExists) {
            return ResponseEntity.badRequest().body(
                    new ResultData(
                            meta: new Meta(MetaResponse.USERNAME_ALREADY_EXISTS)
                    )
            )
        }

        Optional<Role> roleAdmin = roleRepository.findByAuthority(RoleAuthority.ROLE_ADMIN.name())
        User user = new User(request)
        user.password = userPasswordEncoder.encode(request.password)
        user.roles = [roleAdmin.get()]
        userRepository.saveAndFlush(user)
        clientDetailsService.newAdminClientDetails(user)
        return ResponseEntity.ok(
                new ResultData(
                        meta: new Meta(MetaResponse.SUCCESS),
                        data: new UserResponse(user, "")
                )
        )
    }
}
