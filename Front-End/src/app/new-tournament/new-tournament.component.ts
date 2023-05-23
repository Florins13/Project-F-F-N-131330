import {ChangeDetectionStrategy, ChangeDetectorRef, Component, OnDestroy, OnInit} from '@angular/core';
import {CreateGenericTournament} from "./models/create-generic-tournament";
import {NewTournamentService} from "./services/new-tournament.service";
import {Subscription} from "rxjs";
import {NewTournament} from "./models/NewTournament";

@Component({
  selector: 'app-new-tournament',
  templateUrl: './new-tournament.component.html',
  styleUrls: ['./new-tournament.component.sass'],
  changeDetection:ChangeDetectionStrategy.OnPush
})
export class NewTournamentComponent implements OnInit, OnDestroy {

  cgt : CreateGenericTournament = {gameType: "POOL", listOfPlayers: ["Nuno", "Andre", "Florin", "Francisco", "Tiago"]};
  player: string = "";
  tournamentSubscription : Subscription | undefined;
  newTournament : NewTournament | undefined;
  constructor(private newTournamentService : NewTournamentService, private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {

  }

  addPlayer() {
    this.cgt.listOfPlayers = [...this.cgt.listOfPlayers, this.player]
  }

  createTournament() {
    this.tournamentSubscription = this.newTournamentService.createTournament(this.cgt).subscribe(data => {
      this.newTournament = data;
      this.cdr.detectChanges();
    });
  }

  ngOnDestroy(): void {
    this.tournamentSubscription?.unsubscribe();
  }
}
