
import { Injectable } from '@angular/core';
import { Student } from '../model/student';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class RegisterService {
  
  //headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');

  constructor(private http: HttpClient) { }

register(userDetails: Student): Observable<Object> {
    let headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');

    return this.http.post("http://localhost:8080/register", userDetails,{headers: headers})
    };
  }