import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PracticeComponent } from './practice/practice.component';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import { HeroService } from "./services/hero.service";
import { RedCompComponent } from './red-comp/red-comp.component';
import { BlueCompComponent } from './blue-comp/blue-comp.component';
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    AppComponent,
    PracticeComponent,
    RedCompComponent,
    BlueCompComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [HeroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
