import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import {StoreService} from "../store/store.service";
import {Observable} from "rxjs";
import {Tournament} from "./models/Tournament";
import {GenericMatch} from "./models/GenericMatch";

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

    // tnm.matches.forEach(phase => {
    //   if(this.checkPhaseValidaty(phase)){
    //     return true;
    //   }
    //   else {
    //     console.log()
    //   };
    // }
    // )

    return false;;

    }

  private checkPhaseValidaty(phase: GenericMatch[]) {
    return phase.some(game =>
      (game.resultOne >= 0 && !game.resultTwo) ||
      (!game.resultOne && game.resultTwo >= 0) || (game.resultOne ? game.resultOne === game.resultTwo : false)
    );
  }

}
