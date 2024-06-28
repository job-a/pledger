import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, FormControl, ReactiveFormsModule } from '@angular/forms';
import { BalanceItem } from '../../../shared/model/BalanceItem';
import { Button } from 'primeng/button';
import { InputNumberModule } from 'primeng/inputnumber';

@Component({
  selector: 'app-balance-item-form',
  standalone: true,
  imports: [ReactiveFormsModule, Button, InputNumberModule],
  templateUrl: './balance-item-form.component.html',
  styleUrl: './balance-item-form.component.css'
})
export class BalanceItemFormComponent {
  private readonly defaultBalanceItem: BalanceItem = {name: '', startingValuation: 0, currentValuation: 0, description: ''}
  balanceItemForm = this.fb.group(this.defaultBalanceItem)
  @Output() cancelEvent = new EventEmitter<void>()
  @Output() saveEvent = new EventEmitter<BalanceItem>()

  constructor(private readonly fb: FormBuilder) {}

  @Input()
  set balanceItem(balanceItem: BalanceItem) {
    this.balanceItemForm.patchValue(balanceItem)
    this.startingValuationFormControl.disable()
  }

  private get startingValuationFormControl(): FormControl {
    return this.balanceItemForm.get('startingValuation') as FormControl
  }

  save(): void {
    // reading from a disabled form control gives a value of 0, so I have to temporarily enable it
    this.startingValuationFormControl.enable()
    this.saveEvent.emit(Object.assign(this.defaultBalanceItem, this.balanceItemForm.value))
    this.startingValuationFormControl.disable()
  }

}
