package com.github.joba.pledger.service.financial

import com.github.joba.pledger.entity.financial.Category

sealed interface CategoryService {
    fun getAllCategories(): Set<Category>
    fun create(category: Category): Category
}