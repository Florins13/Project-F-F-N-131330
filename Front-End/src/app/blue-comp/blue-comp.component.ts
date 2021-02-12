import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-blue-comp',
  templateUrl: './blue-comp.component.html',
  styleUrls: ['./blue-comp.component.sass']
})
export class BlueCompComponent implements OnInit {

  @Input()
  public numberReceived : number = 0;

  @Output() newItemEvent = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }

  increaseNumber() : void {
    this.numberReceived = this.numberReceived + 1;
    this.newItemEvent.emit(this.numberReceived);
  }
}
