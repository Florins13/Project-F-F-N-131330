import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { map } from 'rxjs/operators';
import { StoreService } from '../store/store.service';
import { Tournament } from '../view/models/Tournament';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-edit-tournament',
  templateUrl: './edit-tournament.component.html',
  styleUrls: ['./edit-tournament.component.sass'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EditTournamentComponent implements OnInit {

  constructor(private route: ActivatedRoute, private store : StoreService, private http: HttpClient) { }

  tournamentid: number | undefined;
  
  tournament$ = this.store.tournaments$.pipe(map(tnm => tnm.find( t => t.id === this.tournamentid )));

  ngOnInit(): void {
    this.tournamentid = parseInt(this.route.snapshot.paramMap.get('id') ?? '');
  }
  
  onUpdateTournament(tnm: Tournament): void {
    this.tournament$ = this.http.post<any>(environment.apiUrl + "/genericTournament/update", tnm);
  }

}
