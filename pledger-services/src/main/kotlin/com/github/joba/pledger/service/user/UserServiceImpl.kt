package com.github.joba.pledger.service.user

import com.github.joba.pledger.entity.user.User
import com.github.joba.pledger.repository.UserRepository
import org.springframework.stereotype.Service

@Service
internal class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun verifyOrCreateUser(user: User): User {
        return userRepository.findByAuthenticatedId(user.authenticatedId)?: userRepository.createUser(user)
    }

}