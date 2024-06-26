import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BalanceItemConfigPageComponent } from './balance-item-config-page.component';

describe('BalanceItemConfigPageComponent', () => {
  let component: BalanceItemConfigPageComponent;
  let fixture: ComponentFixture<BalanceItemConfigPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BalanceItemConfigPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BalanceItemConfigPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
