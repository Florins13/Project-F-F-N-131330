import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MainService {

  constructor(private http: HttpClient) { }

  getTournaments(): Observable<any> {
    return this.http.get<any>(environment.apiUrl + "/genericTournament/getAllTournaments");
  }
}
