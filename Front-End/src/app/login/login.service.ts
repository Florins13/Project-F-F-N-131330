import {Injectable} from '@angular/core';
import {HttpClient,} from '@angular/common/http';
import {Subscription} from "rxjs";
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  getUserFromLogin(params : any): Subscription {

    return this.http.post<any>(environment.apiUrl + "/login", params).subscribe(data => {
      console.log(data);
    })
  }
}



