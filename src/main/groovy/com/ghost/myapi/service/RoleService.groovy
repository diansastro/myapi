package com.ghost.myapi.service

import com.ghost.myapi.enums.RoleAuthority
import com.ghost.myapi.model.entity.Role
import com.ghost.myapi.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.core.env.Profiles
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-17.
 **/

@Service
class RoleService {

    static final String PROFILE_TEST = "test"

    @Autowired
    RoleRepository roleRepository

    @Autowired
    Environment environment

    @PostConstruct
    void postConstruct() {
        if (!environment.acceptsProfiles(Profiles.of(PROFILE_TEST))) {
            Role roleAdmin = new Role(authority: RoleAuthority.ROLE_ADMIN.name())
            Role roleStaff = new Role(authority: RoleAuthority.ROLE_STAFF.name())
            Role roleLecturer = new Role(authority: RoleAuthority.ROLE_LECTURER.name())
            Role roleStudent = new Role(authority: RoleAuthority.ROLE_STUDENT.name())

            if (!roleRepository.findByAuthority(roleAdmin.authority).isPresent()) {
                roleRepository.saveAndFlush(roleAdmin)
            }

            if (!roleRepository.findByAuthority(roleStaff.authority).isPresent()) {
                roleRepository.saveAndFlush(roleStaff)
            }

            if (!roleRepository.findByAuthority(roleLecturer.authority).isPresent()) {
                roleRepository.saveAndFlush(roleLecturer)
            }

            if (!roleRepository.findByAuthority(roleStudent.authority).isPresent()) {
                roleRepository.saveAndFlush(roleStudent)
            }
        }
    }
}
