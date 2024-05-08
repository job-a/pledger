package com.github.joba.pledger.repository.user

import com.github.joba.pledger.entity.user.User
import com.github.joba.pledger.service.user.UserRepository
import org.springframework.stereotype.Repository

@Repository
internal class UserRepositoryImpl(val userRepository: UserJpaRepository): UserRepository {

    override fun findByAuthenticatedId(authenticatedId: String): User? {
        return userRepository.findUserDAOByAuthenticatedId(authenticatedId)?.toUserEntity()
    }

    override fun saveUser(user: User): User {
        return userRepository.save(UserDAO.from(user)).toUserEntity()
    }
}