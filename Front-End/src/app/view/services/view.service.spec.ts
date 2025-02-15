import { TestBed } from '@angular/core/testing';

import { ViewService } from './view.service';

describe('MainService', () => {
  let service: ViewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
