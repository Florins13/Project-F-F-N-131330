import {Component, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-red-comp',
  templateUrl: './red-comp.component.html',
  styleUrls: ['./red-comp.component.sass']
})
export class RedCompComponent implements OnInit {

  @Input()
  public testNum : number = 0;

  @Output()
  public numberRed: number =0;

  constructor() { }

  ngOnInit(): void {
  }

 increaseNumber() : void {
    this.numberRed = this.testNum++;
 }
}
