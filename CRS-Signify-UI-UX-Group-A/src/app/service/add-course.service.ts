import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Addcourse } from '../model/addcourse';

@Injectable({
  providedIn: 'root'
})
export class AddCourseService {

  constructor(private http: HttpClient) { }

  course(courseDetails: Addcourse): Observable<Object> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.post("http://localhost:8080/addCourse", courseDetails,{headers: headers})
  }
  
}
