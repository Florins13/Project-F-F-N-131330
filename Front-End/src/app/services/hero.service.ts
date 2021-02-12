import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Users } from "../hero";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  private Url = 'https://jsonplaceholder.typicode.com/posts';  // URL to web api

  constructor(
    private http: HttpClient
  ) { }

  getHeroes(): Observable<any[]> {
    return this.http.get<any[]>(this.Url)
  }
}
