package com.ghost.myapi.repository

import com.ghost.myapi.model.entity.oauth.OauthAccessToken
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-17.
 **/

@Repository
interface OauthAccessTokenRepository extends JpaRepository<OauthAccessToken, Long> {
    void deleteByClientId(String clientId)
}