package com.github.joba.pledger.entity.financial

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertIs

class AssetTest {
    @Test
    fun testValidInstantiation() {
        val zeroAsset = Asset("First", BigDecimal.valueOf(0))
        val positiveAsset = Asset("Second", BigDecimal.valueOf(100.95))
        assertIs<Asset>(zeroAsset)
        assertIs<Asset>(positiveAsset)
        println(positiveAsset)
        assertEquals(Asset("Second", BigDecimal.valueOf(100.95), ""), positiveAsset)
    }

    @Test
    fun testInvalidInstantiation() {
        assertFails { Asset("Third", BigDecimal.valueOf(-1)) }
    }

    @Test
    fun testCantCreateInvalidCopy() {
        val positiveAsset = Asset("Second", BigDecimal.valueOf(100.95))
        assertFails { positiveAsset.copy("Any", BigDecimal.valueOf(-100.95)) }
    }
}
