import {HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor() {}

    intercept(req: HttpRequest<any>, next: HttpHandler) {

      // TODO {skipp login and register}

      const authReq = req.clone({
        headers: req.headers.set('Authorization', 'Bearer ' + localStorage.authenticationData)
      });

      return next.handle(authReq);
  }


}
