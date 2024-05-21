package com.github.joba.pledger.service.financial

import com.github.joba.pledger.entity.financial.Category
import com.github.joba.pledger.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
internal class CategoryServiceImpl(private val categoryRepository: CategoryRepository) : CategoryService {
    override fun getCategories(): Set<Category> {
        return categoryRepository.getCategories()
    }

    override fun createCategory(category: Category): Category {
        return categoryRepository.createCategory(category)
    }
}