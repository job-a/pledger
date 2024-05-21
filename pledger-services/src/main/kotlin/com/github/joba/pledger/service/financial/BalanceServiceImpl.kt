package com.github.joba.pledger.service.financial


import com.github.joba.pledger.entity.financial.BalanceItem
import com.github.joba.pledger.entity.financial.PeriodBalance
import com.github.joba.pledger.repository.BalanceRepository
import org.springframework.stereotype.Service

@Service
internal class BalanceServiceImpl(private val balanceRepository: BalanceRepository) : BalanceService {
    override fun getBalance(): PeriodBalance {
        return PeriodBalance(emptyList(), emptyList())
    }

    override fun createBalanceItem(balanceItem: BalanceItem): BalanceItem {
        return balanceRepository.createBalanceItem(balanceItem)
    }

}