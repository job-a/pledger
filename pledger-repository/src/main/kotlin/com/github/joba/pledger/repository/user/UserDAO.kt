package com.github.joba.pledger.repository.user

import com.github.joba.pledger.entity.user.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user")
internal data class UserDAO(@GeneratedValue @Id val id: Long ?= null, val authenticatedId: String, val givenName: String) {

    fun toUserEntity(): User {
        return User(authenticatedId, givenName)
    }

    companion object {
        fun from(user: User): UserDAO {
            return UserDAO(authenticatedId = user.authenticatedId, givenName = user.givenName)
        }
    }

}
