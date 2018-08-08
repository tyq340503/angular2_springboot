import { Injectable } from '@angular/core';
import {User} from '../models/user';
import {Photo} from '../models/photo'
import { Headers, Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PhotoService {
    constructor(private http: Http) { }

    getPhotoListByUser(user: User) {
        let token = localStorage.getItem('token');
        let url = "http://localhost:8080/rest/photo/user";
        let header = new Headers({ 'Content-Type': 'application/json', 'Authorization': 'token ' + token });

        return this.http.post(url, user, { headers: header });
    }
}