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

@Component({
  selector: 'app-cash-flow-container',
  standalone: true,
  imports: [
    CommonModule,
    TotalCardComponent,
    PeriodPickerComponent
  ],
  templateUrl: './cash-flow-container.component.html',
  styleUrl: './cash-flow-container.component.css'
})
export class CashFlowContainerComponent {
  selectedPeriod = signal<SelectedPeriod>({periodStart: DateTime.local(DateTime.now().year), periodEnd: DateTime.local(DateTime.now().year).endOf('year')})
  displayPeriod = computed(() => {return `${this.selectedPeriod().periodStart.toLocaleString()} - ${this.selectedPeriod().periodEnd.toLocaleString()}`})
  cashFlowReport$ = toObservable(this.selectedPeriod).pipe(
    switchMap(period => this.transactionService.getCashFlowReport(period.periodStart.toMillis(), period.periodEnd.toMillis()))
  )

  constructor(private readonly transactionService: TransactionService) {}

  onSelectedPeriodChanged(event: SelectedPeriod): void {
    this.selectedPeriod.set(event)
  }

  addIncome() {
    this.transactionService.createTransaction({
      "amount": -100,
      "description": "AT1",
      "timestamp": "2024-05-18T12:50:48.422533Z",
      "balanceItem": {
        "name": "Bunq spaarrekening",
        "startingValuation": 10000,
        "currentValuation": 9200,
        "description": "NL48 BUNQ 0000.000.000"
      },
      "category": {
        "name": "Test",
        "type": "INCOME"
      }
    }).subscribe()
  }

}
