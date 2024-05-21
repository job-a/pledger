package com.github.joba.pledger.repository.financial

import com.github.joba.pledger.entity.financial.Category
import com.github.joba.pledger.repository.CategoryRepository
import com.github.joba.pledger.repository.user.UserRepositoryImpl
import org.springframework.stereotype.Repository

@Repository
internal class CategoryRepositoryImpl(private val categoryJpaRepository: CategoryJpaRepository, private val userRepository: UserRepositoryImpl) : CategoryRepository {
    override fun getAllCategories(): Set<Category> {
        return categoryJpaRepository.findAllByUser(userRepository.getCurrentAuthenticatedUser())
            .map { categoryDao -> categoryDao.toCategory() }
            .toSet()
    }

    override fun createCategory(category: Category): Category {
        return categoryJpaRepository.save(CategoryDAO.from(category, userRepository.getCurrentAuthenticatedUser())).toCategory()
    }

}