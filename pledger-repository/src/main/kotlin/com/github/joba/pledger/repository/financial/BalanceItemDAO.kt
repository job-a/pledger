package com.github.joba.pledger.repository.financial

import com.github.joba.pledger.entity.financial.BalanceItem
import com.github.joba.pledger.repository.user.UserDAO
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "balance_item", uniqueConstraints = [
    UniqueConstraint(name = "balance_item_name_user_key", columnNames = ["name", "user_id"])
])
internal data class BalanceItemDAO(
    @GeneratedValue @Id val id: Long ?= null,
    val name: String,
    val startingValuation: BigDecimal,
    var currentValuation: BigDecimal,
    var description: String,
    @ManyToOne @JoinColumn(name = "user_id") val user: UserDAO) {

    fun toBalanceItem(): BalanceItem {
        return BalanceItem(name, startingValuation, currentValuation, description)
    }

    companion object {
        fun from(balanceItem: BalanceItem, user: UserDAO): BalanceItemDAO {
            return BalanceItemDAO(name = balanceItem.name,
                startingValuation = balanceItem.startingValuation,
                currentValuation = balanceItem.currentValuation,
                description = balanceItem.description, user = user)
        }
    }

}
