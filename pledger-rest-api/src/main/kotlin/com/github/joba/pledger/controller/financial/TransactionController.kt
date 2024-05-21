package com.github.joba.pledger.controller.financial

import com.github.joba.pledger.entity.financial.Transaction
import com.github.joba.pledger.service.financial.TransactionService
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/transaction")
class TransactionController(private val transactionService: TransactionService) {

    @PostMapping(consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun createTransaction(@RequestBody transaction: Transaction): Transaction {
        return transactionService.create(transaction)
    }
}