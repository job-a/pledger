package com.github.joba.pledger.service.user

import com.github.joba.pledger.entity.user.User

interface UserService {
    fun verifyOrCreateUser(user: User): User
}