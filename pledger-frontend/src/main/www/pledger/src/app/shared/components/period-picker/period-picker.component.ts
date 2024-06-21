import { Component, EventEmitter, Output } from '@angular/core';
import { SelectButtonModule } from 'primeng/selectbutton';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { DateTime } from 'luxon';

export enum Period {
  YEAR = 'YEAR',
  MONTH = 'MONTH',
  DAY = 'DAY'
}

export interface SelectedPeriod {
  periodStart: DateTime
  periodEnd: DateTime
}

@Component({
  selector: 'app-period-picker',
  standalone: true,
  imports: [
    FormsModule,
    SelectButtonModule,
    ButtonModule
  ],
  templateUrl: './period-picker.component.html',
  styleUrl: './period-picker.component.css'
})
export class PeriodPickerComponent {
  private readonly defaultPeriodStart = DateTime.local(DateTime.now().year)
  private readonly defaultPeriodEnd = this.defaultPeriodStart.endOf('year')
  private periodStart = this.defaultPeriodStart
  private periodEnd = this.defaultPeriodEnd
  readonly selectButtonOptions = [Period.YEAR, Period.MONTH, Period.DAY]
  private selectedOption = Period.YEAR
  @Output() periodTypeChanged = new EventEmitter<Period>()
  @Output() selectedPeriodChanged = new EventEmitter<SelectedPeriod>()

  onSelectButtonChange(event: any): void {
    this.selectedOption = event.value
    switch (event.value) {
      case Period.YEAR:
        this.switchToYear()
        break
      case Period.MONTH:
        this.switchToMonth()
        break
      case Period.DAY:
        this.switchToDay()
        break
    }
    this.emitPeriodChanged()
  }

  onPeriodBack(): void {
    switch (this.selectedOption) {
      case Period.YEAR:
        this.periodStart = this.periodStart.minus({ year: 1})
        this.periodEnd = this.periodEnd.minus({ year: 1})
        break
      case Period.MONTH:
        this.periodStart = this.periodStart.minus({ month: 1})
        this.periodEnd = this.periodEnd.minus({ month: 1}).endOf('month')
        break
      case Period.DAY:
        this.periodStart = this.periodStart.minus({ day: 1})
        this.periodEnd = this.periodEnd.minus({ day: 1})
        break
    }
    this.emitPeriodChanged()
  }

  onPeriodForward(): void {
    switch (this.selectedOption) {
      case Period.YEAR:
        this.periodStart = this.periodStart.plus({ year: 1})
        this.periodEnd = this.periodEnd.plus({ year: 1})
        break
      case Period.MONTH:
        this.periodStart = this.periodStart.plus({ month: 1})
        this.periodEnd = this.periodEnd.plus({ month: 1}).endOf('month')
        break
      case Period.DAY:
        this.periodStart = this.periodStart.plus({ day: 1})
        this.periodEnd = this.periodEnd.plus({ day: 1})
        break
    }
    this.emitPeriodChanged()
  }

  private switchToYear(): void {
    this.periodStart = this.defaultPeriodStart
    this.periodEnd = this.defaultPeriodEnd
    this.periodTypeChanged.emit(Period.YEAR)
  }

  private switchToMonth(): void {
    const now = DateTime.now()
    this.periodStart = DateTime.local(now.year, now.month)
    this.periodEnd = this.periodStart.endOf('month')
    this.periodTypeChanged.emit(Period.MONTH)
  }

  private switchToDay(): void {
    const now = DateTime.now()
    this.periodStart = DateTime.local(now.year, now.month, now.day)
    this.periodEnd = this.periodStart.endOf('day')
    this.periodTypeChanged.emit(Period.DAY)
  }

  private emitPeriodChanged(): void {
    this.selectedPeriodChanged.emit({periodStart: this.periodStart, periodEnd: this.periodEnd})
  }

}
