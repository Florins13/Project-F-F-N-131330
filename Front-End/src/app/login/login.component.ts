import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {LoginService} from "./login.service";

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

  constructor(private fb: FormBuilder, private loginService : LoginService) {
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

    this.loginService.getUserFromLogin( this.loginForm.value);
  }

}
