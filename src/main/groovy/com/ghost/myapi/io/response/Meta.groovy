package com.ghost.myapi.io.response

import com.ghost.myapi.enums.MetaResponse

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

class Meta {

    int code

    Boolean status

    String message

    Meta() {
    }

    Meta(MetaResponse response) {
        this.code = response.code ?: 400
        this.status = response.status ?: Boolean.FALSE
        this.message = response.message
    }
}
