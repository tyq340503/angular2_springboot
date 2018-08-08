import { Component } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'navbar',
  templateUrl:'./navbar.component.html'
})
export class NavBarComponent  {
    constructor(private loginService:LoginService){}

    onClick(){
      if(this.loginService.checkLogin()){
        this.loginService.logout();
      }
    }
}
