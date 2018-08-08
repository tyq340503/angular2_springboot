import { Component } from '@angular/core';
import { User } from '../models/user';
import { RegisterService } from '../service/register.service'

@Component({
  selector: 'register',
  templateUrl: './register.component.html'
})
export class RegisterComponent {
  newuser: User = new User();
  registered: boolean = false;

  constructor(private registerservice: RegisterService) { }

  onSubmit() {
    console.log(this.newuser);
    this.registerservice.sendUser(this.newuser).subscribe(
      data => {
        this.registered = true;
        this.newuser = new User();
      },
      error => console.log(error)
    );
    
  }
}
