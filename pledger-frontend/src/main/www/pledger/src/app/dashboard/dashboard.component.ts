import { Component } from '@angular/core';
import { CashFlowContainerComponent } from './cash-flow/cash-flow-container/cash-flow-container.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    CashFlowContainerComponent
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

}
