import { Component } from '@angular/core';
import { LoginService } from '../service/login.service'

@Component({
  selector: 'login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
  // newuser: User = new User();
  private checkuser = { 'username': '', 'password': '' };
  // registered: boolean = false;

  constructor(private loginService: LoginService) { }

  onSubmit() {
    console.log(this.checkuser);
    this.loginService.checkUser(this.checkuser).subscribe(
      data => {
        // this.registered = true;
        console.log(data);
        localStorage.setItem('token', JSON.parse(JSON.stringify(data))._body);
        // this.newuser = new User();
        this.loginService.sendToken(localStorage.getItem('token')).subscribe(
          data => {
            localStorage.setItem('username', this.checkuser.username);
            this.checkuser.username = "";
            this.checkuser.password = "";
          }
        )
      },
      error => console.log(error)
    );

  }
}
