import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CardModule } from 'primeng/card';
import { Button } from 'primeng/button';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-total-card',
  standalone: true,
  imports: [
    NgIf,
    CardModule,
    Button
  ],
  templateUrl: './total-card.component.html',
  styleUrl: './total-card.component.css'
})
export class TotalCardComponent {

  @Input() title = ''
  @Input() period = ''
  @Input() amount = 0
  @Input() showButtons = false
  @Output() add = new EventEmitter<void>()

}
