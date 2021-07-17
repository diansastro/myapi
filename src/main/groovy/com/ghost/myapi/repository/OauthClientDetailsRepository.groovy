package com.ghost.myapi.repository

import com.ghost.myapi.model.entity.oauth.OauthClientDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-17.
 **/

@Repository
interface OauthClientDetailsRepository extends JpaRepository<OauthClientDetails, Long> {
    void deleteAllByClientId(String clientId)
}