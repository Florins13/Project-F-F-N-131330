import {Component, OnInit} from '@angular/core';
import {UntypedFormBuilder, Validators} from '@angular/forms';
import {LoginService} from "./services/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  loginForm = this.fb.group({
    username: ['',Validators.required],
    password: ['',Validators.required]
  });

  constructor(private fb: UntypedFormBuilder, private loginService : LoginService, private router : Router) {
  }

  ngOnInit(): void {
  }

  get f(){
    return this.loginForm.controls;
  }

  onAttemptLogin() {
    // TODO: Use EventEmitter with form value
    if(!this.loginForm.value.username || !this.loginForm.value.password){
      alert("Fields are missing");
      return;
    }

    this.loginService.getUserFromLogin( this.loginForm.value).subscribe((userInfo)=>{

      localStorage.isAuthenticated = userInfo.authenticated;
      this.router.navigate(['/home'])
    })
  }

}
