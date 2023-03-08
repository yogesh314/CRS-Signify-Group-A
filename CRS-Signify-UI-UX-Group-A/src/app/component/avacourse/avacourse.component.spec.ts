import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvacourseComponent } from './avacourse.component';

describe('AvacourseComponent', () => {
  let component: AvacourseComponent;
  let fixture: ComponentFixture<AvacourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AvacourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AvacourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
