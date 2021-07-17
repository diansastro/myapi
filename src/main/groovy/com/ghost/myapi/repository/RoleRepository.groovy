package com.ghost.myapi.repository

import com.ghost.myapi.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-17.
 **/

@Repository
interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByAuthority(String authority)
}