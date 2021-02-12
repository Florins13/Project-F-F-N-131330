import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  public numero : number = 0;
  state = 0;


  buttonClick() : void {
    this.numero++;
  }


  getNumberFromBlue(fromBlueNumber: number) {
    this.state = fromBlueNumber;
  }

  getNumberFromRed(fromRedNumber: number) {
    this.state = fromRedNumber;
  }
}
