package com.github.joba.pledger.service.financial

import com.github.joba.pledger.entity.financial.Transaction
import com.github.joba.pledger.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
internal class TransactionServiceImpl(private val transactionRepository: TransactionRepository) : TransactionService {
    override fun create(transaction: Transaction): Transaction {
        return transactionRepository.create(transaction)
    }
}