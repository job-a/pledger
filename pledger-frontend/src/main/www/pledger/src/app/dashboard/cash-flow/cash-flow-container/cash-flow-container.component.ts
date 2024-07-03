import { Component, computed, signal } from '@angular/core';
import { TotalCardComponent } from '../total-card/total-card.component';
import { CommonModule } from '@angular/common';
import { DateTime } from 'luxon';
import { toObservable } from '@angular/core/rxjs-interop';
import { switchMap } from 'rxjs';
import {
  PeriodPickerComponent,
  SelectedPeriod
} from '../../../shared/components/period-picker/period-picker.component';
import { TransactionService } from '../../../shared/services/transaction.service';
import { DialogModule } from 'primeng/dialog';
import { TransactionFormComponent } from '../../../forms/transaction-form/transaction-form.component';
import { Transaction } from '../../../shared/model/Transaction';

@Component({
  selector: 'app-cash-flow-container',
  standalone: true,
  imports: [
    CommonModule,
    DialogModule,
    TotalCardComponent,
    PeriodPickerComponent,
    TransactionFormComponent
  ],
  templateUrl: './cash-flow-container.component.html',
  styleUrl: './cash-flow-container.component.css'
})
export class CashFlowContainerComponent {
  showTransactionForm = false
  selectedPeriod = signal<SelectedPeriod>({periodStart: DateTime.local(DateTime.now().year), periodEnd: DateTime.local(DateTime.now().year).endOf('year')})
  displayPeriod = computed(() => {return `${this.selectedPeriod().periodStart.toLocaleString()} - ${this.selectedPeriod().periodEnd.toLocaleString()}`})
  cashFlowReport$ = toObservable(this.selectedPeriod).pipe(
    switchMap(period => this.transactionService.getCashFlowReport(period.periodStart.toMillis(), period.periodEnd.toMillis()))
  )

  constructor(private readonly transactionService: TransactionService) {}

  onSelectedPeriodChanged(event: SelectedPeriod): void {
    this.selectedPeriod.set(event)
  }

  toggleTransactionForm(): void {
    this.showTransactionForm = !this.showTransactionForm
  }

  saveTransaction(transaction: Transaction): void {
    this.transactionService.createTransaction(transaction).subscribe(() => this.toggleTransactionForm())
  }
}
