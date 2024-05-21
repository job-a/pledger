package com.github.joba.pledger.entity.financial

import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class Liability( val name: String,  val valuation: BigDecimal,  val description: String = "") {
    init {
        require(ZERO.compareTo(valuation) > 0 ) {"The value of a liability must be a negative number."}
    }
}
