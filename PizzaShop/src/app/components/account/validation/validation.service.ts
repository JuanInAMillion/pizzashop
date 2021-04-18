import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import {User} from '../../../models/User';
import {catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ValidationServiceService {
  baseUrl = 'http://localhost:9095/account/userpage/';
  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders ({
      'Content-Type' : 'application/json',
    }),
  };

  validateUser(email: string, password: string): Observable<User> {
    let info = {email,password};
    return this.http.post<User>(
        `${this.baseUrl}login`, JSON.stringify(info), this.httpOptions
    ).pipe(
     retry(1),
     catchError(this.errorHandler)
    );
  }

  errorHandler(error:any) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    }else{
      errorMessage = `Error Status: ${error.status}\nMessage: ${error.message}`
    }
    console.log(errorMessage);
    alert("Invalid username or password, please try again.")
    return throwError(errorMessage);
  }


}