import { Component, OnInit } from '@angular/core';
import { AvailableCourse } from 'src/app/model/available-course';
import { AvacourseService } from 'src/app/service/avacourse.service';

@Component({
  selector: 'app-avacourse',
  templateUrl: './avacourse.component.html',
  styleUrls: ['./avacourse.component.css']
})
export class AvacourseComponent implements OnInit {


  avaCourseArray:Array<AvailableCourse>=new Array();
  model=new AvailableCourse('');
  constructor(private avacourse: AvacourseService) { }

  ngOnInit(): void {
  }

  avaCourse(){
    let avaCourseDetails = new AvailableCourse(this.model.studentid);

    console.log(avaCourseDetails);
   this.avacourse.course(avaCourseDetails).subscribe(
      response => {
        console.log('Response:', response);
        // handle the response as needed
      },
      error => {
        console.log('Error:', error);
        // handle the error as needed
      }
    );
  }

}
