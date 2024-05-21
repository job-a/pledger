package com.github.joba.pledger.repository.financial

import com.github.joba.pledger.entity.exception.IllegalTransactionException
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
        val balanceItemAttached = balanceJpaRepository.findByUserAndName(user, transaction.balanceItem.name)?: throw IllegalTransactionException(unknownDaoMessage("balance item"))
        balanceItemAttached.currentValuation = transaction.balanceItem.currentValuation
        val transactionDao = TransactionDAO.fromTransaction(transaction, balanceItemAttached,
            categoryJpaRepository.findByUserAndNameAndType(user, transaction.category.name, transaction.category.type)?: throw IllegalTransactionException(unknownDaoMessage("category")))
        return transactionJpaRepository.save(transactionDao)
            .toTransaction()
    }

    private val unknownDaoMessage = { item: String -> "Unknown $item for this transaction"}
}