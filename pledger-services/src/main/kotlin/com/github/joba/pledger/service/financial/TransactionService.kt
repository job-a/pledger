package com.github.joba.pledger.service.financial

import com.github.joba.pledger.entity.financial.CashFlowReport
import com.github.joba.pledger.entity.financial.Transaction
import java.time.Instant

interface TransactionService {
    fun create(transaction: Transaction): Transaction
    fun getCashFlowReportForPeriod(periodStart: Instant, periodEnd: Instant): CashFlowReport
}