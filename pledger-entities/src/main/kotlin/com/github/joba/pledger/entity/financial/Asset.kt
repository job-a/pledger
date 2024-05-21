package com.github.joba.pledger.entity.financial

import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class Asset ( val name: String,  val valuation: BigDecimal,  val description: String = "") {
    init {
        require(ZERO.compareTo(valuation) <= 0 ) {"The value of an asset must be a positive number or zero."}
    }
}
