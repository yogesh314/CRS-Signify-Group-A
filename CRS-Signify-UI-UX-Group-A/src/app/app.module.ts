import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SemesterRegistrationComponent } from './component/semester-registration/semester-registration.component';
import { AddCourseComponent } from './component/add-course/add-course.component';
import { DropCourseComponent } from './component/drop-course/drop-course.component';
import { LogoutComponent } from './component/logout/logout.component';
import { ViewRegisteredCourseComponent } from './component/view-registered-course/view-registered-course.component';
import { PayFeeComponent } from './component/pay-fee/pay-fee.component';
import { RegisterComponent } from './component/register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { AvacourseComponent } from './component/avacourse/avacourse.component';

@NgModule({
  declarations: [
    AppComponent,
    SemesterRegistrationComponent,
    AddCourseComponent,
    DropCourseComponent,
    LogoutComponent,
    ViewRegisteredCourseComponent,
    PayFeeComponent,
    RegisterComponent,
    AvacourseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
