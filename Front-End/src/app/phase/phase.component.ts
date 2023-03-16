import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {GenericMatch} from "../view/models/GenericMatch";

@Component({
  selector: 'app-phase',
  templateUrl: './phase.component.html',
  styleUrls: ['./phase.component.sass'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PhaseComponent implements OnInit {
  @Input() phase?: GenericMatch[];

  constructor() { }

  ngOnInit(): void {
  }

}
