package com.ghost.myapi.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.ghost.myapi.model.BaseModelEntity
import org.hibernate.annotations.NaturalId

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

@Entity
class Role extends BaseModelEntity {

    @NaturalId
    @Column(unique = true, nullable = false)
    String authority

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    Set<User> users
}
