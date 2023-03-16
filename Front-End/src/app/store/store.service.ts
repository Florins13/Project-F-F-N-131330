import { Injectable } from '@angular/core';
import {ViewService} from "../view/services/view.service";
import {Observable} from "rxjs";
import {Tournament} from "../view/models/Tournament";

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  constructor(private mainService : ViewService) { }


  tournaments$: Observable<Tournament[]> = this.mainService.getTournaments();

}
