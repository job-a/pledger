package com.github.joba.pledger.repository.financial

import com.github.joba.pledger.entity.financial.Category
import com.github.joba.pledger.entity.financial.Transaction
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "transaction")
internal data class TransactionDAO(@GeneratedValue @Id val id: Long ?= null,
                                   val amount: BigDecimal,
                                   val description: String,
                                   val timestamp: Instant,
                                   @ManyToOne @JoinColumn(name = "balance_item_id") val balanceItem: BalanceItemDAO,
                                   @ManyToOne @JoinColumn(name = "category_id") val category: CategoryDAO) {

    fun toTransaction(): Transaction {
        return Transaction(amount, description, timestamp, balanceItem.toBalanceItem(), Category("Test", Category.Type.INCOME))
    }

    companion object {
        fun fromTransaction(transaction: Transaction, balanceItem: BalanceItemDAO, category: CategoryDAO): TransactionDAO {
            return TransactionDAO(amount = transaction.amount,
                description = transaction.description,
                timestamp = transaction.timestamp,
                balanceItem = balanceItem,
                category = category)
        }
    }


}
