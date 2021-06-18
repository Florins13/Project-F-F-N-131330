import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import {LoginService} from "./login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  loginForm = this.fb.group({
    name: ['',Validators.required],
    password: ['',Validators.required]
  });

  constructor(private fb: FormBuilder, private loginService : LoginService) {
  }

  ngOnInit(): void {
  }

  onAttemptLogin() {
    // TODO: Use EventEmitter with form value
    if(!this.loginForm.value.name || !this.loginForm.value.password){
      alert("Fields are missing");
      return;
    }
    console.log(this.loginForm.value);
    this.loginService.getUserFromLogin( {"username":this.loginForm.value.username, "password": this.loginForm.value.password});
  }

}
