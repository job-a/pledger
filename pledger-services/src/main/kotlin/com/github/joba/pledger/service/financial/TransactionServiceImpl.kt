package com.github.joba.pledger.service.financial

import com.github.joba.pledger.entity.financial.Transaction
import com.github.joba.pledger.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
internal class TransactionServiceImpl(private val transactionRepository: TransactionRepository, private val balanceService: BalanceService) : TransactionService {

    override fun create(transaction: Transaction): Transaction {
        balanceService.read(transaction.balanceItem)
        return transactionRepository.create(transaction.applyToBalance())
    }

}