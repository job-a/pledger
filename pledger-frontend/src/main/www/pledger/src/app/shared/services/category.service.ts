import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, ReplaySubject, take, tap } from 'rxjs';
import { Category } from '../model/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private apiUrl = '/api/category'
  private categoryState = new ReplaySubject<Category[]>(1)

  constructor(private readonly http: HttpClient) {
    this.refreshState()
  }

  getAllCategories(): Observable<Category[]> {
    return this.categoryState.asObservable()
  }

  create(category: Category): Observable<Category> {
    return this.http.post<Category>(this.apiUrl, category).pipe(
      tap(result => this.addToState(result))
    )
  }

  private refreshState(): void {
    this.http.get<Category[]>(this.apiUrl).subscribe(result => this.categoryState.next(result))
  }

  private addToState(newItem: Category): void {
    this.categoryState.pipe(
      take(1)
    ).subscribe(oldItems => this.categoryState.next([...oldItems, ...[newItem]]))
  }
}
