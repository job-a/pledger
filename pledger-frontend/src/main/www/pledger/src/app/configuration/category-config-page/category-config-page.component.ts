import { Component } from '@angular/core';
import { Category } from '../../shared/model/Category';
import { CategoryService } from '../../shared/services/category.service';
import { AsyncPipe, NgIf } from '@angular/common';
import { PrimeTemplate } from 'primeng/api';
import { TableModule } from 'primeng/table';
import { Button } from 'primeng/button';
import { BalanceItemFormComponent } from '../balance-item-config-page/balance-item-form/balance-item-form.component';
import { DialogModule } from 'primeng/dialog';
import { CategoryFormComponent } from './category-form/category-form.component';

@Component({
  selector: 'app-category-config-page',
  standalone: true,
  imports: [
    AsyncPipe,
    NgIf,
    PrimeTemplate,
    TableModule,
    Button,
    BalanceItemFormComponent,
    DialogModule,
    CategoryFormComponent
  ],
  templateUrl: './category-config-page.component.html',
  styleUrl: './category-config-page.component.css'
})
export class CategoryConfigPageComponent {
  showDialog = false

  constructor(readonly categoryService: CategoryService) {}

  toggleDialog(): void {
    this.showDialog = !this.showDialog
  }

  addCategory(category: Category): void {
    this.categoryService.create(category).subscribe(newList => this.toggleDialog())
  }
}
