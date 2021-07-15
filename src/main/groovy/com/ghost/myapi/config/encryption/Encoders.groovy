package com.ghost.myapi.config.encryption

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-15.
 **/

@Configuration
class Encoders {
    @Bean
    PasswordEncoder oauthClientPasswordEncoder() {
        return new BCryptPasswordEncoder(10)
    }

    @Bean
    PasswordEncoder userPasswordEncoder() {
        return new BCryptPasswordEncoder(10)
    }
}
