package com.github.joba.pledger.entity.financial

import java.math.BigDecimal

data class BalanceItem(val name: String, val startingValuation: BigDecimal, val currentValuation: BigDecimal, val description: String = "")