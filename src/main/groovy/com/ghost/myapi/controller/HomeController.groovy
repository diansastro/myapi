package com.ghost.myapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

@RestController
@RequestMapping("")
class HomeController {

    @GetMapping("")
    String homePage() {
        return "It's Works"
    }
}
