import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    const token = localStorage.authenticationData;

    return AuthGuard.checkTokenValidity(token) ? true : this.router.navigate(["/login"]) ;
  }

  private static checkTokenValidity(token : string) : boolean {
    return token !== undefined && (Math.floor((new Date).getTime() / 1000)) <= (JSON.parse(atob(token.split('.')[1]))).exp;
  }
}
