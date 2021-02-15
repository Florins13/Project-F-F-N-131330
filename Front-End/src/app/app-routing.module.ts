import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BlueCompComponent} from "./blue-comp/blue-comp.component";
import {RedCompComponent} from "./red-comp/red-comp.component";
import {AppComponent} from "./app.component";
import {PracticeComponent} from "./practice/practice.component";

const routes: Routes = [
  { path: 'red', component: RedCompComponent },
  { path: 'blue', component: BlueCompComponent },
  { path: '', component: AppComponent },
  { path: '**', component: PracticeComponent},
  { path: '', redirectTo: 'blue', pathMatch: 'full'}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
// { enableTracing: true }
export class AppRoutingModule { }
