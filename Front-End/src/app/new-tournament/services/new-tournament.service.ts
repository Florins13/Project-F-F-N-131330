import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {CreateGenericTournament} from "../models/create-generic-tournament";
import {HttpClient} from "@angular/common/http";
import {Tournament} from "../../view/models/Tournament";
import {Observable} from "rxjs";
import {NewTournament} from "../models/NewTournament";

@Injectable({
  providedIn: 'root'
})
export class NewTournamentService {

  constructor(private http: HttpClient) { }

  createTournament(cgt :CreateGenericTournament) : Observable<NewTournament> {

    return this.http.post<NewTournament>(environment.apiUrl + "/genericTournament/createSinglePlayers", cgt);
  }
}
