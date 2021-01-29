import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-practice',
  templateUrl: './practice.component.html',
  styleUrls: ['./practice.component.sass']
})
export class PracticeComponent implements OnInit {

  @Input() test : number = 0;

  constructor() { }

  ngOnInit(): void {
    this.test = 0;
  }


}
