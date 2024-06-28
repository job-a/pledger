import { Component } from '@angular/core';
import { AsyncPipe, NgIf } from '@angular/common';
import { TableModule } from 'primeng/table';
import { BalanceService } from '../../shared/services/balance.service';
import { Button } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { BalanceItemFormComponent } from './balance-item-form/balance-item-form.component';
import { BalanceItem } from '../../shared/model/BalanceItem';

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
  showDialog = false
  balanceItemToEdit: BalanceItem | null = null

  constructor(readonly balanceService: BalanceService) {}

  toggleDialog(): void {
    if (this.showDialog) {
      this.balanceItemToEdit = null
    }
    this.showDialog = !this.showDialog
  }

  addBalanceItem(item: BalanceItem): void {
    this.balanceService.create(item).subscribe(() => this.toggleDialog())
  }

  editBalanceItem(item: BalanceItem): void {
    console.log('editing not yet implemented')
  }

}
