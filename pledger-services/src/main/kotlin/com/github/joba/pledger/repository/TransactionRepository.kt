package com.github.joba.pledger.repository

import com.github.joba.pledger.entity.financial.Transaction

interface TransactionRepository {
    fun create(transaction: Transaction): Transaction
}