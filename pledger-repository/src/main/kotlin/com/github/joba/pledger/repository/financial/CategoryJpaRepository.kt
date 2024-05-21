package com.github.joba.pledger.repository.financial

import com.github.joba.pledger.entity.financial.Category
import com.github.joba.pledger.repository.user.UserDAO
import org.springframework.data.repository.CrudRepository

internal interface CategoryJpaRepository : CrudRepository<CategoryDAO, Long> {
    fun findAllByUser(userDAO: UserDAO): List<CategoryDAO>
    fun findByUserAndNameAndType(userDAO: UserDAO, name: String, type: Category.Type): CategoryDAO?
}