package com.ghost.myapi.model.entity.oauth

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

@Entity
class OauthApprovals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String userid

    String clientid

    String scope

    String status

    Date expire

    Date lastmodified
}
