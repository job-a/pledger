package com.github.joba.pledger.entity.financial

data class Liability(override val name: String, override val worth: Long, override val description: String): BalanceItem(name, worth, description)
