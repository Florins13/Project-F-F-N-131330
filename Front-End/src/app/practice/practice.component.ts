import {Component, Input, OnInit, Output} from '@angular/core';
import {Users} from "../hero";

@Component({
  selector: 'app-practice',
  templateUrl: './practice.component.html',
  styleUrls: ['./practice.component.sass']
})
export class PracticeComponent implements OnInit {

  @Input()
  name : string = "jansdflsdmnfsdkflk";
  users : Users[] = [];

  constructor(
    ) { }


  ngOnInit(): void {
  }



}
