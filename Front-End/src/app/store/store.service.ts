import { Injectable } from '@angular/core';
import {MainService} from "../main/services/main.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  constructor(private mainService : MainService) { }


  tournament$: Observable<any> = this.mainService.getTournaments();

}
