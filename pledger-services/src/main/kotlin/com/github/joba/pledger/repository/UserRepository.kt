package com.github.joba.pledger.repository

import com.github.joba.pledger.entity.user.User

interface UserRepository {
    fun findByAuthenticatedId(authenticatedId: String): User?
    fun createUser(user: User): User
}