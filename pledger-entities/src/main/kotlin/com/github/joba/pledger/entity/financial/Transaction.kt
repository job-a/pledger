package com.github.joba.pledger.entity.financial

import java.math.BigDecimal
import java.time.Instant

data class Transaction(val amount: BigDecimal,
                       val description: String,
                       val timestamp: Instant,
                       val balanceItem: BalanceItem,
                       val category: Category) {

    fun applyToBalance(): Transaction {
        return copy(balanceItem = balanceItem.copy(currentValuation = balanceItem.currentValuation.add(amount)))
    }
}
