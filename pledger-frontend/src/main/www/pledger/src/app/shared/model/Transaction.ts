import { BalanceItem } from './BalanceItem';
import { Category } from './Category';

export interface Transaction {
  amount: number
  description: string
  timestamp: string
  balanceItem: BalanceItem
  category: Category
}
