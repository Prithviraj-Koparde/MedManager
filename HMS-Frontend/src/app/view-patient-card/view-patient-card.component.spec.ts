import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPatientCardComponent } from './view-patient-card.component';

describe('ViewPatientCardComponent', () => {
  let component: ViewPatientCardComponent;
  let fixture: ComponentFixture<ViewPatientCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewPatientCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewPatientCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
