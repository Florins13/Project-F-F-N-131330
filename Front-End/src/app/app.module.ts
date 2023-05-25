import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import { NavComponent } from './nav/nav.component';
import { HeaderComponent } from './header/header.component';
import { ViewComponent } from './view/view.component';
import { MatchBoxComponent } from './match-box/match-box.component';
import { PhaseComponent } from './phase/phase.component';
import { NewTournamentComponent } from './new-tournament/new-tournament.component';
import {AuthInterceptor} from "./auth/auth-interceptor";
import {MatExpansionModule} from "@angular/material/expansion";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    NavComponent,
    HeaderComponent,
    ViewComponent,
    MatchBoxComponent,
    PhaseComponent,
    NewTournamentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    MatExpansionModule,
    BrowserAnimationsModule ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
