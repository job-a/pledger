package com.github.joba.pledger.service.financial

import com.github.joba.pledger.entity.financial.BalanceReport
import com.github.joba.pledger.entity.financial.BalanceItem

sealed interface BalanceService {
    fun getBalanceReport(): BalanceReport
    fun create(balanceItem: BalanceItem): BalanceItem
    fun read(balanceItem: BalanceItem): BalanceItem
}