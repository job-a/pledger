package com.github.joba.pledger.repository.financial

import com.github.joba.pledger.repository.user.UserDAO
import org.springframework.data.repository.CrudRepository
import java.math.BigDecimal

internal interface BalanceJpaRepository : CrudRepository<BalanceItemDAO, Long> {
    fun findAllByUser(user: UserDAO): List<BalanceItemDAO>
    fun findByUserAndNameAndCurrentValuation(user: UserDAO, name: String, currentValuation: BigDecimal): BalanceItemDAO?
}