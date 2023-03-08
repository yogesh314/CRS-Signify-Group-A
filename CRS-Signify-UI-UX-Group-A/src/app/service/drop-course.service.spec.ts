import { TestBed } from '@angular/core/testing';

import { DropCourseService } from './drop-course.service';

describe('DropCourseService', () => {
  let service: DropCourseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DropCourseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
