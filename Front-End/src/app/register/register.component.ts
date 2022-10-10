import {Component, OnInit} from '@angular/core';
import {UntypedFormBuilder, UntypedFormGroup, Validators} from "@angular/forms";
import {RegisterService} from "./services/register.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {

  registerForm = this.fb.group({
    username: ['',Validators.required],
    password: ['',Validators.required],
    confirmPassword: ['',Validators.required],
    email: ['',Validators.required]
  }, {validator: this.ConfirmedValidator('password', 'confirmPassword')
  });
  constructor(private fb: UntypedFormBuilder, private registerService : RegisterService) { }

  ngOnInit(): void {
  }

  ConfirmedValidator(password: string, confirmPassword : string){
    return (formGroup : UntypedFormGroup) => {
      const pass = formGroup.controls[password];
      const confirmPass = formGroup.controls[confirmPassword];
      if(confirmPass.errors && !confirmPass.errors.confirmedValidator) {
        return;
      }
      if(pass.value !== confirmPass.value){
        confirmPass.setErrors({confirmedValidator : true});
      } else {
        confirmPass.setErrors(null);
      }
    }
  }

  get f(){
    return this.registerForm.controls;
  }

  onAttemptRegister(){
    this.registerService.registerUser(this.registerForm.value);
  };

}
