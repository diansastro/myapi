package com.ghost.myapi.service

import com.ghost.myapi.model.entity.User
import com.ghost.myapi.model.entity.oauth.OauthClientDetails
import com.ghost.myapi.repository.OauthClientDetailsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

@Service
class OauthClientDetailsService {

    private final static String ADMIN_SCOPE = "read,write,admin"
    private final static String STAFF_SCOPE = "read,write,staff"
    private final static String LECTUREE_SCOPE = "read,write,lecturer"
    private final static String STUDENT_SCOPE = "read,write,student"

    @Autowired
    PasswordEncoder oauthClientPasswordEncoder

    @Value('${oauth2.resources.id}')
    String resourcesId

    @Value('${oauth2.scope.read.write}')
    String scopeReadWrite

    @Value('${oauth2.authorize.grant.type}')
    String authorizeGrantType

    @Autowired
    OauthClientDetailsRepository oauthClientDetailsRepository

    OauthClientDetails newAdminClientDetails(User user) throws Throwable {
        OauthClientDetails oauthClientDetails = oauthClientDetailsRepository.saveAndFlush(new OauthClientDetails(
                clientId: user?.username,
                resourceIds: resourcesId,
                clientSecret: oauthClientPasswordEncoder.encode(user?.clientSecret),
                scope: ADMIN_SCOPE,
                authorizedGrantTypes: authorizeGrantType,
                authorities: "ADMIN",
                accessTokenValidity: 86400,
                refreshTokenValidity: 2592000
        ))

        if (oauthClientDetails) {
            return oauthClientDetails
        }

        return null
    }
}
