import { Component, OnInit } from '@angular/core';
import { Addcourse } from 'src/app/model/addcourse';
import { AddCourseService } from 'src/app/service/add-course.service';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  CourseArray:Array<Addcourse>=new Array();
  model=new Addcourse('','',0);
  constructor(private addcourse: AddCourseService) { }

  ngOnInit(): void {
  }

  addCourse(){
    console.log("Add Course");


    let courseDetails = new Addcourse(this.model.studentid,this.model.coursecode,this.model.type);

    console.log(courseDetails);
   this.addcourse.course(courseDetails).subscribe(
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
