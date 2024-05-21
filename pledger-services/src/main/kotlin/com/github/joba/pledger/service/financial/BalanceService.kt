package com.github.joba.pledger.service.financial

import com.github.joba.pledger.entity.financial.PeriodBalance
import com.github.joba.pledger.entity.financial.BalanceItem

sealed interface BalanceService {
    fun getBalance(): PeriodBalance
    fun createBalanceItem(balanceItem: BalanceItem): BalanceItem
}