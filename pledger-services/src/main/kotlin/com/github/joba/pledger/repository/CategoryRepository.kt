package com.github.joba.pledger.repository

import com.github.joba.pledger.entity.financial.Category

interface CategoryRepository {
    fun getAllCategories(): Set<Category>
    fun createCategory(category: Category): Category
}