package com.ghost.myapi.repository

import com.ghost.myapi.enums.UserStatus
import com.ghost.myapi.enums.UserType
import com.ghost.myapi.model.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

@Repository
interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndStatus(String username, UserStatus status)

    Boolean existsByUsernameAndStatusNot(String username, UserStatus status)

    Page<User> findAllByUserTypeAndStatus(Pageable pageable, UserType type, UserStatus status)
}