import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {GenericMatch} from "../main/models/GenericMatch";

@Component({
  selector: 'app-match-box',
  templateUrl: './match-box.component.html',
  styleUrls: ['./match-box.component.sass'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MatchBoxComponent implements OnInit {
  @Input() game!: GenericMatch;
  playerOneResult : number = 0;
  playerTwoResult : number = 1;

  constructor() { }

  ngOnInit(): void {
  }

}
