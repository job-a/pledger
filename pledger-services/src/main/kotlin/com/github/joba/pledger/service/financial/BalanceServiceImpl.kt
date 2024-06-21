package com.github.joba.pledger.service.financial


import com.github.joba.pledger.entity.exception.NotFoundException
import com.github.joba.pledger.entity.financial.BalanceItem
import com.github.joba.pledger.entity.financial.BalanceReport
import com.github.joba.pledger.repository.BalanceRepository
import org.springframework.stereotype.Service

@Service
internal class BalanceServiceImpl(private val balanceRepository: BalanceRepository) : BalanceService {
    override fun getBalanceReport(): BalanceReport {
        return BalanceReport(emptyList(), emptyList())
    }

    override fun create(balanceItem: BalanceItem): BalanceItem {
        return balanceRepository.createBalanceItem(balanceItem)
    }

    override fun read(balanceItem: BalanceItem): BalanceItem {
        return balanceRepository.readBalanceItem(balanceItem)?: throw NotFoundException("Unknown balance item in request")
    }

}