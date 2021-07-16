package com.ghost.myapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version
import java.time.LocalDateTime

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

@MappedSuperclass
class BaseModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Version
    @JsonIgnore
    Long version

    @CreationTimestamp
    LocalDateTime createAt

    @UpdateTimestamp
    LocalDateTime updateAt
}
