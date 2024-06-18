package com.github.joba.pledger.repository.user

import com.github.joba.pledger.entity.user.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user")
data class UserDAO(@GeneratedValue @Id val id: Long ?= null, @Column(unique = true) val authenticatedId: String, @Column val givenName: String) {

    fun toUser(): User {
        return User(authenticatedId, givenName)
    }

    companion object {
        fun from(user: User): UserDAO {
            return UserDAO(authenticatedId = user.authenticatedId, givenName = user.givenName)
        }
    }

}
