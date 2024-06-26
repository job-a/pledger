import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CashFlowContainerComponent } from './cash-flow-container.component';

describe('TotalsContainerComponent', () => {
  let component: CashFlowContainerComponent;
  let fixture: ComponentFixture<CashFlowContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CashFlowContainerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CashFlowContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
