package com.github.joba.pledger.repository

import com.github.joba.pledger.entity.financial.BalanceItem

interface BalanceRepository {
    fun createBalanceItem(balanceItem: BalanceItem): BalanceItem
    fun readBalanceItem(balanceItem: BalanceItem): BalanceItem?
    fun readAllBalanceItems(): List<BalanceItem>
}