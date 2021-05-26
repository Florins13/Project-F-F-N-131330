import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable, Subscription} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  getUserFromLogin(params : any): Subscription {

    return this.http.post<any>("http://localhost:8200/login", params).subscribe(data => {
      console.log(data);
    })
  }
}



