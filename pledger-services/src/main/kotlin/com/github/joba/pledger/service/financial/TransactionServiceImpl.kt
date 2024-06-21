package com.github.joba.pledger.service.financial

import com.github.joba.pledger.entity.financial.CashFlowReport
import com.github.joba.pledger.entity.financial.Transaction
import com.github.joba.pledger.repository.TransactionRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
internal class TransactionServiceImpl(private val transactionRepository: TransactionRepository, private val balanceService: BalanceService) : TransactionService {

    override fun create(transaction: Transaction): Transaction {
        balanceService.read(transaction.balanceItem)
        return transactionRepository.create(transaction.applyToBalance())
    }

    override fun getCashFlowReportForPeriod(periodStart: Instant, periodEnd: Instant): CashFlowReport {
        return CashFlowReport(periodStart, periodEnd, transactionRepository.getAllTransactionsInPeriod(periodStart, periodEnd))
    }

}