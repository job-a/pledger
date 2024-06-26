import { Component } from '@angular/core';
import { AsyncPipe, NgIf } from '@angular/common';
import { TableModule } from 'primeng/table';
import { BalanceService } from '../../shared/services/balance.service';
import { Button } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { BalanceItemFormComponent } from './balance-item-form/balance-item-form.component';
import { BalanceItem } from '../../shared/model/BalanceItem';
import { map, ReplaySubject, switchMap, take } from 'rxjs';

@Component({
  selector: 'app-balance-item-config-page',
  standalone: true,
  imports: [
    TableModule,
    AsyncPipe,
    NgIf,
    Button,
    DialogModule,
    BalanceItemFormComponent
  ],
  templateUrl: './balance-item-config-page.component.html',
  styleUrl: './balance-item-config-page.component.css'
})
export class BalanceItemConfigPageComponent {
  balanceItems = new ReplaySubject<BalanceItem[]>(1)
  showDialog = false
  balanceItemToEdit: BalanceItem | null = null

  constructor(private readonly balanceService: BalanceService) {
    this.balanceService.getAllBalanceItems().subscribe(items => this.balanceItems.next(items))
  }

  toggleDialog(): void {
    if (this.showDialog) {
      this.balanceItemToEdit = null
    }
    this.showDialog = !this.showDialog
  }

  addBalanceItem(item: BalanceItem): void {
    this.balanceService.create(item).pipe(
      switchMap(newItem => this.balanceItems.pipe(
        take(1),
        map(items => [...items, ...[newItem]])
      ))
    ).subscribe(items => {
      this.balanceItems.next(items)
      this.toggleDialog()
    })
  }

  editBalanceItem(item: BalanceItem): void {
    console.log('editing not yet implemented')
  }

}
