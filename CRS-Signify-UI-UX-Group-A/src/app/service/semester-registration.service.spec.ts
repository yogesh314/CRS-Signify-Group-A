import { TestBed } from '@angular/core/testing';

import { SemesterRegistrationService } from './semester-registration.service';

describe('SemesterRegistrationService', () => {
  let service: SemesterRegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SemesterRegistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
