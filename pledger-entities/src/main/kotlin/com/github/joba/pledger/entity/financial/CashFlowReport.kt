package com.github.joba.pledger.entity.financial

import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.time.Instant

class CashFlowReport(val reportStartTime: Instant, val reportEndTime: Instant, val transactions: List<Transaction>) {

    fun getTotalIncome(): BigDecimal {
        return transactions
            .filter { transaction -> ZERO.compareTo(transaction.amount).equals(-1) }
            .sumOf { transaction -> transaction.amount }
    }

    fun getTotalExpense(): BigDecimal {
        return transactions
            .onEach { println("unfiltered $it") }
            .filter { transaction -> ZERO.compareTo(transaction.amount).equals(1) }
            .onEach { println("filtered $it") }
            .sumOf { transaction -> transaction.amount }
    }

    fun getCashFlow() : BigDecimal {
        return getTotalExpense().add(getTotalIncome())
    }

}