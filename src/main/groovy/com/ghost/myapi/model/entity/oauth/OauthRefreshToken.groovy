package com.ghost.myapi.model.entity.oauth

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

@Entity
class OauthRefreshToken {
    @Id
    String tokenId

    @Lob
    @Column(columnDefinition = "BLOB")
    byte[] token

    @Lob
    @Column(columnDefinition = "BLOB")
    byte[] authentication
}
