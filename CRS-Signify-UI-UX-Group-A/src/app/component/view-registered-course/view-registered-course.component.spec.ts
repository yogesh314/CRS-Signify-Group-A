import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRegisteredCourseComponent } from './view-registered-course.component';

describe('ViewRegisteredCourseComponent', () => {
  let component: ViewRegisteredCourseComponent;
  let fixture: ComponentFixture<ViewRegisteredCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRegisteredCourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRegisteredCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
