import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Student } from 'src/app/model/student';
import { RegisterService } from 'src/app/service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class RegisterComponent implements OnInit {

  //name:string,userId:string,address:string,password:string,doj:string,studentid:string,age:number,fname:string,bloodgroup:string,phnum:string,branch:string

  UserArray:Array<Student>=new Array();
  model=new Student('','','','','','',0,'','','','');
  
  constructor(private registerService: RegisterService) { 
  }

  ngOnInit(): void {
  }

  registerUser(){
    console.log("User Registration");

   let userDetails = new Student(this.model.name,this.model.userId,this.model.address,this.model.password,this.model.doj,this.model.studentid,this.model.age,this.model.fname,this.model.bloodgroup,this.model.phnum,this.model.branch);

    console.log(userDetails);
   this.registerService.register(userDetails).subscribe(
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