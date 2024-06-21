package com.github.joba.pledger.entity.financial

import java.math.BigDecimal

class BalanceReport(val assets: List<BalanceItem>, val liabilities: List<BalanceItem>) {
    fun getAssetTotal(): BigDecimal {
        return BigDecimal.TEN
    }

    fun getLiabilityTotal(): BigDecimal {
        return BigDecimal.TEN
    }

    fun getCashFlowTotal(): BigDecimal {
        return BigDecimal.TEN
    }
}
