import {Component, Input, OnInit, Output} from '@angular/core';
import {Users} from "../hero";
import {HeroService} from "../services/hero.service";

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
    private heroService: HeroService,) { }

  hero: Users = {
    id: 1,
    title: 'Windstorm',
    body: "20",
    userId: 1
  };

  HEROES: string[] = [
    "Dr Nice",
    "Dr Nice1",
    "Dr Nice2",
    "Dr Nice3"
  ];

  ngOnInit(): void {
    this.name = "init"
  }

  getStuff(): void {
    this.heroService.getHeroes().subscribe(heroes =>
    {
      this.users = heroes
      console.log(this.users)
    });

  }


}
