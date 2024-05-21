package com.github.joba.pledger.entity.financial

import java.math.BigDecimal

class PeriodBalance(val assets: List<BalanceItem>, val liabilities: List<BalanceItem>) {
    fun getAssetTotal(): BigDecimal {
        TODO("Not yet implemented")
    }

    fun getLiabilityTotal(): BigDecimal {
        TODO("Not yet implemented")
    }

    fun getCashFlowTotal(): BigDecimal {
        TODO("Not yet implemented")
    }
}
