package com.github.joba.pledger.entity.financial

data class Category(val name: String, val type: Type) {
    enum class Type { INCOME, EXPENSE }
}