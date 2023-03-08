import { TestBed } from '@angular/core/testing';

import { ViewRegisteredCourseService } from './view-registered-course.service';

describe('ViewRegisteredCourseService', () => {
  let service: ViewRegisteredCourseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewRegisteredCourseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
