package com.github.joba.pledger.repository

import com.github.joba.pledger.entity.financial.BalanceItem

interface BalanceRepository {
    fun getAllBalanceItems(): List<BalanceItem>
    fun createBalanceItem(balanceItem: BalanceItem): BalanceItem
    fun readBalanceItem(balanceItem: BalanceItem): BalanceItem?
}