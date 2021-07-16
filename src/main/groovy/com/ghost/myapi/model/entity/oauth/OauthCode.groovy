package com.ghost.myapi.model.entity.oauth

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

@Entity
class OauthCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String code

    @Lob
    @Column(columnDefinition = "BLOB")
    byte[] authentication
}
