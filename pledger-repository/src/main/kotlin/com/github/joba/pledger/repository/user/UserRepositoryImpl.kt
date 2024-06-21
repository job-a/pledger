package com.github.joba.pledger.repository.user

import com.github.joba.pledger.entity.exception.InvalidUserException
import com.github.joba.pledger.entity.user.User
import com.github.joba.pledger.repository.UserRepository
import com.github.joba.pledger.repository.extensions.getSubject
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.stereotype.Repository

@Repository
internal class UserRepositoryImpl(private val userJpaRepository: UserJpaRepository): UserRepository, AuthenticatedUserRepository {


    override fun findByAuthenticatedId(authenticatedId: String): User? {
        return userJpaRepository.findUserDAOByAuthenticatedId(authenticatedId)?.toUser()
    }

    override fun createUser(user: User): User {
        return userJpaRepository.save(UserDAO.from(user)).toUser()
    }

    override fun getCurrentAuthenticatedUser(): UserDAO {
        val token = SecurityContextHolder.getContext().authentication as OAuth2AuthenticationToken
        return userJpaRepository.findUserDAOByAuthenticatedId(token.getSubject())?: throw InvalidUserException()
    }

}