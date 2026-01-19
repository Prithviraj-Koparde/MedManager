import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicineDashComponent } from './medicine-dash.component';

describe('MedicineDashComponent', () => {
  let component: MedicineDashComponent;
  let fixture: ComponentFixture<MedicineDashComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MedicineDashComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MedicineDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
