import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {CreateGenericTournament} from "./models/create-generic-tournament";
import {NewTournamentService} from "./services/new-tournament.service";

@Component({
  selector: 'app-new-tournament',
  templateUrl: './new-tournament.component.html',
  styleUrls: ['./new-tournament.component.sass'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class NewTournamentComponent implements OnInit {

  cgt :CreateGenericTournament = {gameType: "POOL", listOfPlayers: ["nuno",
      "Florin",
      "johny",
      "player4",
      "player5",
      "6",
      "7",
      "8",
      "9"]};
  player: string = "";
  constructor(private newTournamentService : NewTournamentService) { }

  ngOnInit(): void {

  }

  addPlayer() {
    this.cgt.listOfPlayers = [...this.cgt.listOfPlayers, this.player]
  }

  createTournament() {
    console.log(this.newTournamentService.createTournament(this.cgt));
  }
}
