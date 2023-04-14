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

  cgt :CreateGenericTournament = {gameType: "POOL", listOfPlayers: ["Nuno", "Andre", "Florin", "Francisco", "Tiago"]};
  player: string = "";
  constructor(private newTournamentService : NewTournamentService) { }

  ngOnInit(): void {

  }

  addPlayer() {
    this.cgt.listOfPlayers = [...this.cgt.listOfPlayers, this.player]
  }

  createTournament() {
    this.newTournamentService.createTournament(this.cgt).subscribe();
  }
}
