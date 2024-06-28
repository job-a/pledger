import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryConfigPageComponent } from './category-config-page.component';

describe('CategoryConfigPageComponent', () => {
  let component: CategoryConfigPageComponent;
  let fixture: ComponentFixture<CategoryConfigPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CategoryConfigPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CategoryConfigPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
