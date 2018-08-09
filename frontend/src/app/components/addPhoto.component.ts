import { Component } from '@angular/core';
import { PhotoService } from '../service/photo.service'
import { UserService } from '../service/user.service';
import { Photo } from '../models/photo';
import { User } from '../models/user';

@Component({
  selector: 'addPhoto',
  templateUrl: './addPhoto.component.html'
})
export class AddPhotoComponent {
  private addPhoto: Photo = new Photo();
  private photoFlag: boolean = false;
  private user: User;

  constructor(private photoService: PhotoService, private userService: UserService) {

  }

  onSubmit() {
    let currentUser = localStorage.getItem('username');
    this.userService.getUserName(currentUser).subscribe(
      data => {
        
        this.user = JSON.parse(JSON.parse(JSON.stringify(data))._body);
        this.addPhoto.user = this.user;
        this.photoService.sendPhoto(this.addPhoto).subscribe(
          res => {
            this.photoFlag = true;
            this.addPhoto = new Photo();
          }, error => {
            console.log(error);
          }
        )

      }, error => {
        console.log(error);
      }
    )
    // this.photoService.uploadPhoto()
  }
}
