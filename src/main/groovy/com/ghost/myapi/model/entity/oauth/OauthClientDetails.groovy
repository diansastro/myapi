package com.ghost.myapi.model.entity.oauth

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Size

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

@Entity
class OauthClientDetails {

    @Id
    String clientId

    String resourceIds

    String clientSecret

    String scope

    String authorizedGrantTypes

    String webServerRedirectUri

    String authorities

    Integer accessTokenValidity

    Integer refreshTokenValidity

    @Size(max = 4096)
    String additionalInformation

    String autoapprove
}
