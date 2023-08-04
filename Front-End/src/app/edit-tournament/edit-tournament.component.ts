import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { map } from 'rxjs/operators';
import { StoreService } from '../store/store.service';
import { Tournament } from '../view/models/Tournament';

@Component({
  selector: 'app-edit-tournament',
  templateUrl: './edit-tournament.component.html',
  styleUrls: ['./edit-tournament.component.sass'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EditTournamentComponent implements OnInit {
  

  constructor(private route: ActivatedRoute, private store : StoreService) { }

  tournamentid: number | undefined;
  
  tournament$ = this.store.tournaments$.pipe(map(tnm => tnm.find( t => t.id === this.tournamentid )));

  ngOnInit(): void {
    this.tournamentid = parseInt(this.route.snapshot.paramMap.get('id') ?? '');
  }
  
  onUpdateTournament(tnm: Tournament) {
    //this.tournament$ = this.loginService.getUserFromLogin(tnm); //.subscribe()
  }

}
