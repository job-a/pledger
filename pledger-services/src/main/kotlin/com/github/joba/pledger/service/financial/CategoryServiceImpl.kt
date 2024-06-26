package com.github.joba.pledger.service.financial

import com.github.joba.pledger.entity.financial.Category
import com.github.joba.pledger.entity.financial.Category.Type.EXPENSE
import com.github.joba.pledger.entity.financial.Category.Type.INCOME
import com.github.joba.pledger.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
internal class CategoryServiceImpl(private val categoryRepository: CategoryRepository) : CategoryService {
    override fun getAllCategories(): Set<Category> {
        return categoryRepository.getAllCategories()
    }

    override fun create(category: Category): Category {
        return categoryRepository.createCategory(category)
    }

    override fun createDefaultsForNewUser() {
        categoryRepository.createCategory(Category("Others", INCOME))
        categoryRepository.createCategory(Category("Others", EXPENSE))
    }
}