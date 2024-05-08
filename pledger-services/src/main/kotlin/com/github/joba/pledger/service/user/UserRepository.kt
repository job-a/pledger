package com.github.joba.pledger.service.user

import com.github.joba.pledger.entity.user.User

interface UserRepository {
    fun findByAuthenticatedId(authenticatedId: String): User?
    fun saveUser(user: User): User
}