import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import {StoreService} from "../store/store.service";
import {Observable} from "rxjs";
import {Tournament} from "./models/Tournament";

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.sass'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ViewComponent implements OnInit {

  tournaments$: Observable<Tournament[]> = this.store.tournaments$;
  step: number = 0;

  constructor(private store : StoreService) { }

  ngOnInit(): void {

  }

  getInicialMatches(tnm : Tournament) {
    tnm.initialMatches


  }

  setStep(index: number) {
    this.step = index;
  }

  nextStep() {
    this.step++;
  }

  prevStep() {
    this.step--;
  }

  onUpdateTournament(tnm : Tournament) {
    console.log(this.isThereAnyInvalidMatch(tnm));
  }

  private isThereAnyInvalidMatch(tnm: Tournament) {
    return tnm.matches.some(phase => phase.some(game =>
        (game.resultOne >= 0 && !game.resultTwo) ||
        (!game.resultOne && game.resultTwo >= 0)
      ));
  }
}
