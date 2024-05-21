package com.github.joba.pledger.repository.financial

import com.github.joba.pledger.entity.financial.Category
import com.github.joba.pledger.repository.user.UserDAO
import jakarta.persistence.*
import jakarta.persistence.EnumType.STRING

@Entity
@Table(name = "category", uniqueConstraints = [
    UniqueConstraint(name = "category_name_type_user_key", columnNames = ["name", "type", "user_id"])
])
internal data class CategoryDAO(
    @GeneratedValue @Id val id: Long ?= null,
    val name: String,
    @Enumerated(STRING) val type: Category.Type,
    @ManyToOne @JoinColumn(name = "user_id")  val user: UserDAO) {

    fun toCategory(): Category {
        return Category(name, type)
    }

    companion object {
        fun from(category: Category, user: UserDAO): CategoryDAO {
            return CategoryDAO(name = category.name, type = category.type, user = user)
        }
    }
}
