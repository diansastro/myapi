package com.ghost.myapi.model.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.ghost.myapi.constant.ParamConstants
import com.ghost.myapi.enums.UserStatus
import com.ghost.myapi.enums.UserType
import com.ghost.myapi.io.request.AdminRequest
import com.ghost.myapi.io.request.LecturerRequest
import com.ghost.myapi.io.request.StaffRequest
import com.ghost.myapi.model.BaseModelEntity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.OneToOne

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

@Entity
class User extends BaseModelEntity {

    String username

    String password

    String clientSecret

    UserType userType

    UserStatus status

//    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
//    Staff staff
//
//    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
//    Lecturer lecturer
//
//    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
//    Student student
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
//    StudentLecturer studentLecturer
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    Set<UserFirebase> userFirebases
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    Set<NotificationLog> notificationLogs

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinTable(name = "user_role",
               joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )

    Set<Role> roles

    User() {
    }

    User(AdminRequest request) {
        this.username = request.username
        this.password = request.password
        this.clientSecret = UUID.randomUUID().toString()
        this.userType = UserType.ADMIN
        this.status = UserStatus.ACTIVE
    }

    User(StaffRequest request) {
        this.username = request.employeeId
        this.password = request.password
        this.clientSecret = UUID.randomUUID().toString()
        this.userType = UserType.STAFF
        this.status = UserStatus.ACTIVE
    }

    User(LecturerRequest request) {
        this.username = request.employeeId
        this.password = request.password
        this.clientSecret = UUID.randomUUID().toString()
        this.userType = UserType.LECTURER
        this.status = UserStatus.ACTIVE
    }

    static User newStaff(Map<String, String> params) {
        User u = new User()
        u.username = params.get(ParamConstants.EMPLOYEE_ID)
        u.password = params.get(ParamConstants.PASSWORD)
        u.clientSecret = UUID.randomUUID().toString()
        u.userType = UserType.STAFF
        u.status = UserStatus.ACTIVE
        return u
    }

    static User newLecturer(Map<String, String> params) {
        User u = new User()
        u.username = params.get(ParamConstants.EMPLOYEE_ID)
        u.password = params.get(ParamConstants.PASSWORD)
        u.clientSecret = UUID.randomUUID().toString()
        u.userType = UserType.LECTURER
        u.status = UserStatus.ACTIVE
        return u
    }

    static User newStudent(Map<String, String> params) {
        User u = new User()
        u.username = params.get(ParamConstants.EMPLOYEE_ID)
        u.password = params.get(ParamConstants.PASSWORD)
        u.clientSecret = UUID.randomUUID().toString()
        u.userType = UserType.STUDENT
        u.status = UserStatus.ACTIVE
        return u
    }
}
