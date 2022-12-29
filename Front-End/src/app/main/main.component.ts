import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import {StoreService} from "../store/store.service";
import {Observable} from "rxjs";
import {Tournament} from "./models/Tournament";


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.sass'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MainComponent implements OnInit {

  tournaments$: Observable<Tournament[]> = this.store.tournaments$;

  constructor(private store : StoreService) { }

  ngOnInit(): void {

  }

  getInicialMatches(tmn : Tournament) {
    tmn.initialMatches


  }
}
