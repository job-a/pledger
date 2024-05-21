package com.github.joba.pledger.repository.financial

import com.github.joba.pledger.entity.financial.Transaction
import com.github.joba.pledger.repository.TransactionRepository
import com.github.joba.pledger.repository.user.AuthenticatedUserRepository
import org.springframework.stereotype.Repository

@Repository
internal class TransactionRepositoryImpl(private val transactionJpaRepository: TransactionJpaRepository,
                                         private val balanceJpaRepository: BalanceJpaRepository,
                                         private val categoryJpaRepository: CategoryJpaRepository,
                                         private val userRepository: AuthenticatedUserRepository) : TransactionRepository {

    override fun create(transaction: Transaction): Transaction {
        val user = userRepository.getCurrentAuthenticatedUser()
        return transactionJpaRepository.save(TransactionDAO.fromTransaction(transaction,
            balanceJpaRepository.findByUserAndNameAndCurrentValuation(user, transaction.balanceItem.name, transaction.balanceItem.currentValuation)?: throw IllegalArgumentException(unknownDaoMessage("balance item")),
            categoryJpaRepository.findByUserAndNameAndType(user, transaction.category.name, transaction.category.type)?: throw IllegalArgumentException(unknownDaoMessage("category"))))
            .toTransaction()
    }

    private val unknownDaoMessage = { item: String -> "Unknown $item for this transaction"}
}