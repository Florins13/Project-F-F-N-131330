import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import {StoreService} from "../store/store.service";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.sass'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MainComponent implements OnInit {

  tournament$ = this.store.tournament$;

  constructor(private store : StoreService) { }

  ngOnInit(): void {
    this.tournament$.subscribe(item => console.log(item));
  }

}
