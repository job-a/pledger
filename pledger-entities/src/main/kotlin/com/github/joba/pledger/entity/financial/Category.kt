package com.github.joba.pledger.entity.financial

class Category(val name: String, val type: Type) {
    enum class Type { INCOME, EXPENSE }
}