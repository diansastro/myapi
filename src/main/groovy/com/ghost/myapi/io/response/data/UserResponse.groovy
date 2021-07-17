package com.ghost.myapi.io.response.data

import com.ghost.myapi.model.entity.User

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

class UserResponse {

    Long userId

    String username

    String userType

    String clientSecret

    String status

    Object profile

    UserResponse() {
    }

    UserResponse(User user, Object profile) {
        this.userId = user?.id ?: 0
        this.username = user?.username ?: ""
        this.userType = user?.userType?.name()
        this.clientSecret = user?.clientSecret ?: ""
        this.profile = profile
        this.status = user?.status
    }
}
