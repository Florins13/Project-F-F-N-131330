import { Injectable } from '@angular/core';
import {MainService} from "../main/services/main.service";
import {Observable} from "rxjs";
import {Tournament} from "../main/models/Tournament";

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  constructor(private mainService : MainService) { }


  tournaments$: Observable<Tournament[]> = this.mainService.getTournaments();

}
