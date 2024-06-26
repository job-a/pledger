import { Component } from '@angular/core';
import { BalanceItemConfigPageComponent } from './balance-item-config-page/balance-item-config-page.component';

@Component({
  selector: 'app-configuration',
  standalone: true,
  imports: [
    BalanceItemConfigPageComponent
  ],
  templateUrl: './configuration.component.html',
  styleUrl: './configuration.component.css'
})
export class ConfigurationComponent {

}
