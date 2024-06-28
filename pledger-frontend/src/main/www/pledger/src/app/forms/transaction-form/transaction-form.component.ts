import { Component, EventEmitter, Output } from '@angular/core';
import { Category } from '../../shared/model/Category';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { Transaction } from '../../shared/model/Transaction';
import { BalanceItem } from '../../shared/model/BalanceItem';
import { BalanceService } from '../../shared/services/balance.service';
import { CategoryService } from '../../shared/services/category.service';
import { Button } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { InputNumberModule } from 'primeng/inputnumber';
import { AsyncPipe, NgIf } from '@angular/common';
import { map, Observable } from 'rxjs';

interface CategoryWithDisplayLabel extends Category {
  displayLabel: string
}

@Component({
  selector: 'app-transaction-form',
  standalone: true,
  imports: [
    AsyncPipe,
    NgIf,
    ReactiveFormsModule,
    Button,
    DropdownModule,
    InputNumberModule
  ],
  templateUrl: './transaction-form.component.html',
  styleUrl: './transaction-form.component.css'
})
export class TransactionFormComponent {
  private readonly emptyTransaction: Transaction = {
    amount: 0,
    description: '',
    timestamp: '',
    balanceItem: {} as BalanceItem,
    category: {} as Category
  }
  transactionForm = this.fb.group(this.emptyTransaction)
  @Output() cancelEvent = new EventEmitter<void>()
  @Output() saveEvent = new EventEmitter<Transaction>()

  constructor(private readonly fb: FormBuilder, readonly balanceService: BalanceService, readonly categoryService: CategoryService) {}

  save(): void {
    this.saveEvent.emit(Object.assign(this.emptyTransaction, this.transactionForm.value))
  }

  get categoriesWithLabels(): Observable<CategoryWithDisplayLabel[]> {
    return this.categoryService.getAllCategories().pipe(
      map(categoryList => categoryList.map(category => category as CategoryWithDisplayLabel)),
      map(categoryList => categoryList.map(category => Object.assign(category, {displayLabel: `${category.name} (${category.type})`})))
    )
  }
}
