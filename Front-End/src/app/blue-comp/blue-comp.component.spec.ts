import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlueCompComponent } from './blue-comp.component';

describe('BlueCompComponent', () => {
  let component: BlueCompComponent;
  let fixture: ComponentFixture<BlueCompComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlueCompComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlueCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
