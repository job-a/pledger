package com.github.joba.pledger.controller.financial

import com.github.joba.pledger.entity.financial.Transaction
import com.github.joba.pledger.service.financial.TransactionService
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
@RequestMapping("/api/transaction")
class TransactionController(private val transactionService: TransactionService) {

    @GetMapping(value = ["cashflowreport"], produces = [APPLICATION_JSON_VALUE])
    fun getCashFlowReport(@RequestParam(value = "periodStart") periodStart: String, @RequestParam(value = "periodEnd") periodEnd: String): CashFlowReportDTO {
        return CashFlowReportDTO(transactionService.getCashFlowReportForPeriod(Instant.ofEpochMilli(periodStart.toLong()), Instant.ofEpochMilli(periodEnd.toLong())))
    }

    @PostMapping(consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun createTransaction(@RequestBody transaction: Transaction): Transaction {
        return transactionService.create(transaction)
    }
}