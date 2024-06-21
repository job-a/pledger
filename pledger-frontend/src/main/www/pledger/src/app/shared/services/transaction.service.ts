import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from '../model/Transaction';
import { CashFlowReport } from '../model/CashFlowReport';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private apiUrl = '/api/transaction'

  constructor(private http: HttpClient) {}

  createTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(this.apiUrl, transaction);
  }

  getCashFlowReport(periodStart: number, periodEnd: number): Observable<CashFlowReport> {
    return this.http.get<CashFlowReport>(`${this.apiUrl}/cashflowreport?periodStart=${periodStart}&periodEnd=${periodEnd}`)
  }
}
