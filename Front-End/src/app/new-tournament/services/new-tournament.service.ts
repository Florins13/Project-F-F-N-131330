import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {CreateGenericTournament} from "../models/create-generic-tournament";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Tournament} from "../../view/models/Tournament";

@Injectable({
  providedIn: 'root'
})
export class NewTournamentService {

  constructor(private http: HttpClient) { }

  createTournament(cgt :CreateGenericTournament) : Observable<Tournament>{

    return this.http.post<Tournament>(environment.apiUrl + "/genericTournament/createSinglePlayers", cgt);
  }
}
