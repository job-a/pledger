export interface Category {
  name: String
  type: CategoryType
}

export enum CategoryType {
  INCOME = 'INCOME',
  EXPENSE = 'EXPENSE'
}
