package com.github.joba.pledger.repository.financial

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.time.Instant

internal interface TransactionJpaRepository : CrudRepository<TransactionDAO, Long> {

    @Query("SELECT t FROM TransactionDAO t WHERE t.balanceItem.user.id = ?3 AND t.timestamp >= ?1 AND t.timestamp <= ?2")
    fun findAllInPeriodForUser(periodStart: Instant, periodEnd: Instant, userId: Long): List<TransactionDAO>
}