import { TestBed } from '@angular/core/testing';

import { NewTournamentService } from './new-tournament.service';

describe('NewTournamentService', () => {
  let service: NewTournamentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NewTournamentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
