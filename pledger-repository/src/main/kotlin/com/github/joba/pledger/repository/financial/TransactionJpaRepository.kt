package com.github.joba.pledger.repository.financial

import org.springframework.data.repository.CrudRepository

internal interface TransactionJpaRepository : CrudRepository<TransactionDAO, Long>