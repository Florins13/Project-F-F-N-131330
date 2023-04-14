import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {HomeComponent} from "./home/home.component";
import {AuthGuard} from "./auth/auth.guard";
import {ViewComponent} from "./view/view.component";
import {NewTournamentComponent} from "./new-tournament/new-tournament.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'home', component: HomeComponent, canActivate:[AuthGuard],
    children: [
      {
        path: 'new-tournament',  // child route path
        title: 'New-Tournament',
        component: NewTournamentComponent,  // child route component that the router renders
      },
      {
        path: 'view',  // child route path
        component: ViewComponent,  // child route component that the router renders
      },
      {
        path: 'nav3',  // child route path
        component: ViewComponent,  // child route component that the router renders
      },
      {
        path: 'nav4',  // child route path
        component: ViewComponent,  // child route component that the router renders
      }
      /*{
        path: 'child-b',
        title: 'child b',
        component: ChildBComponent,  // another child route component that the router renders
      },*/
    ]},
  //todo{ create 'cannot find this page' component)
  { path: '**', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
