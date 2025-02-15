import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Tournament} from "../models/Tournament";

@Injectable({
  providedIn: 'root'
})
export class ViewService {

  constructor(private http: HttpClient) { }

  getTournaments(): Observable<Tournament[]> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + btoa("nuno:red")
      })
    };
    return this.http.get<Tournament[]>(environment.apiUrl + "/genericTournament/getAllTournaments", httpOptions);
  }
}
