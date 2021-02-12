import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RedCompComponent } from './red-comp.component';

describe('RedCompComponent', () => {
  let component: RedCompComponent;
  let fixture: ComponentFixture<RedCompComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RedCompComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RedCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
