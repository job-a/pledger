package com.github.joba.pledger.entity.financial

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertFails
import kotlin.test.assertIs

class LiabilityTest {
    @Test
    fun testValidInstantiation() {
        val liability = Liability("Third", BigDecimal.valueOf(-1))
        assertIs<Liability>(liability)
    }

    @Test
    fun testInvalidInstantiationWithZeroAmount() {
        assertFails { Liability("First", BigDecimal.valueOf(0)) }
    }

    @Test
    fun testInvalidInstantiationWithPositiveAmount() {
        assertFails { Liability("Second", BigDecimal.valueOf(100.95)) }
    }

    @Test
    fun testCantCreateInvalidCopy() {
        val liability = Liability("Third", BigDecimal.valueOf(-1))
        assertFails { liability.copy("Any", BigDecimal.valueOf(100.95)) }
    }
}
