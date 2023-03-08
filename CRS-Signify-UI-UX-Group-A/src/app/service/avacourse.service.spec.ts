import { TestBed } from '@angular/core/testing';

import { AvacourseService } from './avacourse.service';

describe('AvacourseService', () => {
  let service: AvacourseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AvacourseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
