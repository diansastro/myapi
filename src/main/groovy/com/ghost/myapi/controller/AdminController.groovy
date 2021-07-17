package com.ghost.myapi.controller

import com.ghost.myapi.io.request.AdminRequest
import com.ghost.myapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

@RestController
@RequestMapping("/admin")
class AdminController {

    @Autowired
    UserService userService

    @GetMapping("")
    ResponseEntity listAdmin(Pageable pageable) {
        return userService.listAdmin(pageable)
    }

    @PostMapping("")
    ResponseEntity saveAdmin(@RequestBody AdminRequest request) {
        return userService.saveAdmin(request)
    }
}
