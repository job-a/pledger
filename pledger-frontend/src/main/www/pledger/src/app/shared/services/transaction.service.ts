import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { Transaction } from '../model/Transaction';
import { CashFlowReport } from '../model/CashFlowReport';
import { BalanceService } from './balance.service';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private apiUrl = '/api/transaction'

  constructor(private readonly http: HttpClient, private readonly balanceService: BalanceService) {}

  createTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(this.apiUrl, transaction).pipe(
      tap(() => this.balanceService.refreshState())
    )
  }

  getCashFlowReport(periodStart: number, periodEnd: number): Observable<CashFlowReport> {
    return this.http.get<CashFlowReport>(`${this.apiUrl}/cashflowreport?periodStart=${periodStart}&periodEnd=${periodEnd}`)
  }
}
