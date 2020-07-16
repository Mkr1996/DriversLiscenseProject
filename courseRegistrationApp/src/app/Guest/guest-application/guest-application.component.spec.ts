import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GuestApplicationComponent } from './guest-application.component';

describe('GuestApplicationComponent', () => {
  let component: GuestApplicationComponent;
  let fixture: ComponentFixture<GuestApplicationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GuestApplicationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GuestApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
