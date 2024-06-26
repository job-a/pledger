package com.github.joba.pledger.service.user

import com.github.joba.pledger.entity.user.User
import com.github.joba.pledger.repository.UserRepository
import com.github.joba.pledger.service.financial.CategoryService
import org.springframework.stereotype.Service

@Service
internal class UserServiceImpl(private val userRepository: UserRepository, private val categoryService: CategoryService) : UserService {

    override fun verifyOrCreateUser(user: User): User {
        return userRepository.findByAuthenticatedId(user.authenticatedId)?: createNewUser(user)
    }

    private fun createNewUser(user: User): User {
        val createdUser = userRepository.createUser(user)
        categoryService.createDefaultsForNewUser()
        return createdUser
    }

}