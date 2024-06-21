package com.github.joba.pledger.controller.financial

import com.fasterxml.jackson.annotation.JsonIgnore
import com.github.joba.pledger.entity.financial.CashFlowReport
import java.math.BigDecimal
import java.time.Instant

class CashFlowReportDTO(@JsonIgnore val cashFlowReport: CashFlowReport) {
    fun getReportStartTime(): Instant {
        return cashFlowReport.reportStartTime
    }

    fun getReportEndTime(): Instant {
        return cashFlowReport.reportEndTime
    }

    fun getTotalIncome(): BigDecimal {
        return cashFlowReport.getTotalIncome()
    }

    fun getTotalExpense(): BigDecimal {
        return cashFlowReport.getTotalExpense()
    }

    fun getCashFlow() : BigDecimal {
        return cashFlowReport.getCashFlow()
    }
}