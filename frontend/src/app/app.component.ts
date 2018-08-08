import { Component } from '@angular/core';
import { Http } from '@angular/http';
import { RegisterService } from './service/register.service';
import { LoginService } from './service/login.service'; 
import { UserService } from './service/user.service'; 
import { PhotoService } from './service/photo.service'; 

@Component({
  selector: 'my-app',
  // directives: [HomeComponent],
  providers: [RegisterService,LoginService,UserService,PhotoService],
  template: `<h1>Hello {{name}}</h1>
  <navbar></navbar>
  <home></home> 
  <router-outlet></router-outlet>         
  `,
})

export class AppComponent { 
  name = 'Angular';
}
