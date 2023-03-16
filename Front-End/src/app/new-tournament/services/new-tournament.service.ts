import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {CreateGenericTournament} from "../models/create-generic-tournament";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class NewTournamentService {

  constructor(private http: HttpClient) { }

  createTournament(cgt :CreateGenericTournament) {

    return this.http.post<CreateGenericTournament>(environment.apiUrl + "/genericTournament/createSinglePlayers", cgt);
  }
}
