package com.github.joba.pledger.service.user

import com.github.joba.pledger.entity.user.User
import org.springframework.stereotype.Service

@Service
internal class UserServiceImpl(val userRepository: UserRepository) : UserService {

    override fun verifyOrCreateUser(user: User): User {
        return userRepository.findByAuthenticatedId(user.authenticatedId)?: userRepository.saveUser(user)
    }

}