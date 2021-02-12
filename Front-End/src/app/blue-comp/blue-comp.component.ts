import {Component, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-blue-comp',
  templateUrl: './blue-comp.component.html',
  styleUrls: ['./blue-comp.component.sass']
})
export class BlueCompComponent implements OnInit {

  @Input()
  public testNum : number = 0;

  @Output()
  public numeroOut : number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  increaseNumber() : void {
    this.numeroOut = this.testNum++;
  }
}
