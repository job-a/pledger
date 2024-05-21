package com.github.joba.pledger.controller.financial

import com.github.joba.pledger.entity.financial.PeriodBalance
import com.github.joba.pledger.entity.financial.BalanceItem
import com.github.joba.pledger.service.financial.BalanceService
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/balance")
class BalanceController(private val balanceService: BalanceService) {

    @GetMapping(produces = [APPLICATION_JSON_VALUE])
    fun getUserBalance(): PeriodBalance {
        return balanceService.getBalance()
    }

    @PostMapping(consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun createBalanceItem(@RequestBody balanceItem: BalanceItem): BalanceItem {
        return balanceService.create(balanceItem)
    }
}