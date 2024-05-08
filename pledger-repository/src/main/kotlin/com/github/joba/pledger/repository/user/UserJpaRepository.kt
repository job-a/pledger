package com.github.joba.pledger.repository.user

import org.springframework.data.repository.CrudRepository

internal interface UserJpaRepository: CrudRepository<UserDAO, Long> {
    fun findUserDAOByAuthenticatedId(authenticatedId: String): UserDAO?
}