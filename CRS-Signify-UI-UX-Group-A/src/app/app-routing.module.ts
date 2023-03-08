import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCourseComponent } from './component/add-course/add-course.component';
import { AvacourseComponent } from './component/avacourse/avacourse.component';
import { DropCourseComponent } from './component/drop-course/drop-course.component';
import { PayFeeComponent } from './component/pay-fee/pay-fee.component';
import { RegisterComponent } from './component/register/register.component';
import { ViewRegisteredCourseComponent } from './component/view-registered-course/view-registered-course.component';

const routes: Routes = [
  {path:'' , redirectTo:'' ,pathMatch:'full'},
  { path:'registeredCourses' , component: ViewRegisteredCourseComponent },
  { path:'availableCourses' , component: AvacourseComponent },
  { path:'addCourse' , component: AddCourseComponent },
  { path:'register' , component: RegisterComponent },
  { path:'payfee' , component: PayFeeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }





// import { NgModule } from '@angular/core';
// import { RouterModule, Routes } from '@angular/router';

// const routes: Routes = [];

// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }
