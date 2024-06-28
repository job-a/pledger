import { Component, EventEmitter, Output } from '@angular/core';
import { Category, CategoryType } from '../../../shared/model/Category';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { Button } from 'primeng/button';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-category-form',
  standalone: true,
  imports: [ReactiveFormsModule, Button, DropdownModule],
  templateUrl: './category-form.component.html',
  styleUrl: './category-form.component.css'
})
export class CategoryFormComponent {
  private readonly defaultCategory: Category = {name: '', type: CategoryType.INCOME}
  categoryForm = this.fb.group(this.defaultCategory)
  categoryTypes = Object.values(CategoryType)
  @Output() cancelEvent = new EventEmitter<void>()
  @Output() saveEvent = new EventEmitter<Category>()

  constructor(private readonly fb: FormBuilder) {}

  save(): void {
    this.saveEvent.emit(Object.assign(this.defaultCategory, this.categoryForm.value))
  }

}
