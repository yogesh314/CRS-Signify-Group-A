import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { AvailableCourse } from '../model/available-course';

@Injectable({
  providedIn: 'root'
})
export class AvacourseService {



  constructor(private http: HttpClient) { }

  course(avaCourseDetails: AvailableCourse): Observable<Object> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.post("http://localhost:8080/avaCourse", avaCourseDetails,{headers: headers})
  }
}
