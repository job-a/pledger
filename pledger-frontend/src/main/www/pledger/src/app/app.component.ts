import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabViewModule } from 'primeng/tabview';
import { DashboardComponent } from './dashboard/dashboard.component';
import {
  BalanceItemConfigPageComponent
} from './configuration/balance-item-config-page/balance-item-config-page.component';
import { CategoryConfigPageComponent } from './configuration/category-config-page/category-config-page.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    TabViewModule,
    DashboardComponent,
    BalanceItemConfigPageComponent,
    CategoryConfigPageComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pledger';
}
