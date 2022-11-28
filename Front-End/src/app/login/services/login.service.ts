import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders,} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  getUserFromLogin(params: any): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa(params.username + ":" + params.password)
      })
    };
    return this.http.post<any>(environment.apiUrl + "/login", params, httpOptions);

  }
}



