import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BlueCompComponent} from "./blue-comp/blue-comp.component";

const routes: Routes = [ { path: 'blue', component: BlueCompComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
// { enableTracing: true }
export class AppRoutingModule { }
