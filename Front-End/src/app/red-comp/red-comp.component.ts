import {Component, EventEmitter, Input, OnInit, Output, SimpleChange, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-red-comp',
  templateUrl: './red-comp.component.html',
  styleUrls: ['./red-comp.component.sass']
})
export class RedCompComponent implements OnInit {

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
