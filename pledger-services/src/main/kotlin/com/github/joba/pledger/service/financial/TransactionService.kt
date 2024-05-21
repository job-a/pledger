package com.github.joba.pledger.service.financial

import com.github.joba.pledger.entity.financial.Transaction

interface TransactionService {
    fun create(transaction: Transaction): Transaction
}