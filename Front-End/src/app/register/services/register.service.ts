import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Subscription} from "rxjs";
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  registerUser(params : any):Subscription {
    return this.http.post<any>(environment.apiUrl + "/registration", params).subscribe(data => {
      console.log(data);
    })
  };
}
