import { Component, EventEmitter, Output } from '@angular/core';
import { Category, CategoryType } from '../../shared/model/Category';
import { FormBuilder, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { Transaction } from '../../shared/model/Transaction';
import { BalanceService } from '../../shared/services/balance.service';
import { CategoryService } from '../../shared/services/category.service';
import { Button } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';
import { InputNumberModule } from 'primeng/inputnumber';
import { AsyncPipe, NgIf } from '@angular/common';
import { map, Observable } from 'rxjs';
import { CalendarModule } from 'primeng/calendar';

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
    InputNumberModule,
    CalendarModule
  ],
  templateUrl: './transaction-form.component.html',
  styleUrl: './transaction-form.component.css'
})
export class TransactionFormComponent {
  transactionForm = this.fb.group({
    amount: [null, [Validators.required, Validators.min(0.01)]],
    description: [''],
    timestamp: [new Date(), [Validators.required]],
    balanceItem: [null, [Validators.required]],
    category: [null, [Validators.required]]
  })
  today = new Date()
  @Output() cancelEvent = new EventEmitter<void>()
  @Output() saveEvent = new EventEmitter<Transaction>()

  constructor(private readonly fb: FormBuilder, readonly balanceService: BalanceService, readonly categoryService: CategoryService) {}

  save(): void {
    if (this.amountControl.enabled && this.transactionForm.valid) {
      this.patchExpenseAmountToNegativeValue()
      this.saveEvent.emit(Object.assign({} as Transaction, this.transactionForm.value))
    }
  }

  get categoriesWithLabels(): Observable<CategoryWithDisplayLabel[]> {
    return this.categoryService.getAllCategories().pipe(
      map(categoryList => categoryList.map(category => category as CategoryWithDisplayLabel)),
      map(categoryList => categoryList.map(category => Object.assign(category, {displayLabel: `${category.name} (${category.type})`})))
    )
  }

  onDatePicked(date: Date): void {
    // we need a Date at UTC time for the backend
    this.transactionForm.get('timestamp')?.patchValue(new Date(Date.UTC(date.getFullYear(), date.getMonth(), date.getDate())))
  }

  private get categoryControl(): FormControl {
    return this.transactionForm.get('category') as FormControl
  }

  private get amountControl(): FormControl {
    return this.transactionForm.get('amount') as FormControl
  }

  private patchExpenseAmountToNegativeValue(): void {
    if (CategoryType.EXPENSE === this.categoryControl.value.type) {
      this.amountControl.patchValue(this.amountControl.value * -1)
    }
  }

}
