import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BalanceItem } from '../model/BalanceItem';
import { Observable, ReplaySubject, take, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BalanceService {
  private apiUrl = '/api/balance'
  private balanceItemState = new ReplaySubject<BalanceItem[]>(1)

  constructor(private readonly http: HttpClient) {
    this.refreshState()
  }

  getAllBalanceItems(): Observable<BalanceItem[]> {
    return this.balanceItemState.asObservable()
  }

  create(balanceItem: BalanceItem): Observable<BalanceItem> {
    return this.http.post<BalanceItem>(this.apiUrl, balanceItem).pipe(
      tap(result => this.addToState(result))
    )
  }

  refreshState(): void {
    this.http.get<BalanceItem[]>(this.apiUrl).subscribe(result => this.balanceItemState.next(result))
  }

  private addToState(newItem: BalanceItem): void {
    this.balanceItemState.pipe(
      take(1)
    ).subscribe(oldItems => this.balanceItemState.next([...oldItems, ...[newItem]]))
  }

}
