package com.github.joba.pledger.repository.user

internal interface AuthenticatedUserRepository {
    fun getCurrentAuthenticatedUser(): UserDAO
}