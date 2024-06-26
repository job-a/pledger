package com.github.joba.pledger.repository.financial

import com.github.joba.pledger.entity.financial.BalanceItem
import com.github.joba.pledger.repository.BalanceRepository
import com.github.joba.pledger.repository.user.AuthenticatedUserRepository
import org.springframework.stereotype.Repository

@Repository
internal class BalanceRepositoryImpl(private val balanceJpaRepository: BalanceJpaRepository, private val userRepository: AuthenticatedUserRepository): BalanceRepository {

    override fun createBalanceItem(balanceItem: BalanceItem): BalanceItem {
        return balanceJpaRepository.save(BalanceItemDAO.from(balanceItem, userRepository.getCurrentAuthenticatedUser())).toBalanceItem()
    }

    override fun readBalanceItem(balanceItem: BalanceItem): BalanceItem? {
        return balanceJpaRepository.findByUserAndNameAndCurrentValuation(userRepository.getCurrentAuthenticatedUser(), balanceItem.name, balanceItem.currentValuation)?.toBalanceItem()
    }

    override fun readAllBalanceItems(): List<BalanceItem> {
        return balanceJpaRepository.findAllByUser(userRepository.getCurrentAuthenticatedUser())
            .map { balanceItemDAO -> balanceItemDAO.toBalanceItem() }
    }

}