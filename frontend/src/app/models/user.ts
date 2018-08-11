import { Photo } from './photo';

export class User {
    private userId: number;
     email: string;
     userName: string;
     password: string;

    private created: Date;

     photoList: Photo[];

    private likedPhotoList: Photo[];

    public getPhotoList(){
        return this.photoList;
    }

}