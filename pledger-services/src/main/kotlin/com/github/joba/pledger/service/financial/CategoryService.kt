package com.github.joba.pledger.service.financial

import com.github.joba.pledger.entity.financial.Category

sealed interface CategoryService {
    fun getCategories(): Set<Category>
    fun createCategory(category: Category): Category
}