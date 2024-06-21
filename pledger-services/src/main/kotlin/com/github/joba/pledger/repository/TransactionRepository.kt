package com.github.joba.pledger.repository

import com.github.joba.pledger.entity.financial.Transaction
import java.time.Instant

interface TransactionRepository {
    fun create(transaction: Transaction): Transaction
    fun getAllTransactionsInPeriod(periodStart: Instant, periodEnd: Instant): List<Transaction>
}