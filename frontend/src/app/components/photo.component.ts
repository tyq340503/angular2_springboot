import { Component } from '@angular/core';
import { Photo } from '../models/photo';
import { UserService } from '../service/user.service';
import { PhotoService } from '../service/photo.service';
import { LoginService } from '../service/login.service';
import { User } from '../models/user';

@Component({
  selector: 'photo',
  templateUrl: './photo.component.html'
})
export class PhotoComponent {
  private photoList: Photo[];
  private user: User;

  constructor(private userService: UserService,
    private photoService: PhotoService,
    private loginService: LoginService) {

    if (!loginService.checkLogin()) {
      throw 'you need to login first';
    }
    this.userService.getUserName(localStorage.getItem('username')).subscribe(
      data => {
        this.user = JSON.parse(JSON.parse(JSON.stringify(data))._body);
        this.photoService.getPhotoListByUser(this.user).subscribe(
          data => {
            this.photoList = this.user.getPhotoList();
          },
          error => {
            console.log(error);
          }
        )
      },
      error => {
        console.log(error);
      }
    )
  }
}
