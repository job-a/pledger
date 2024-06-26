import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BalanceItem } from '../model/BalanceItem';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BalanceService {
  private apiUrl = '/api/balance'

  constructor(private readonly http: HttpClient) {}

  getAllBalanceItems(): Observable<BalanceItem[]> {
    return this.http.get<BalanceItem[]>(this.apiUrl)
  }

  create(balanceItem: BalanceItem): Observable<BalanceItem> {
    return this.http.post<BalanceItem>(this.apiUrl, balanceItem)
  }
}
