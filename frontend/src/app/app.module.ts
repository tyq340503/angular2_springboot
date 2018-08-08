import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HomeComponent } from './components/home.component';
import { HttpModule } from '@angular/http';
import { PhotoListComponent } from './components/photo-list.component';
import { SidebarComponent } from './components/sidebar.component';
import { NavBarComponent } from './components/navbar.component';
import { RegisterComponent } from './components/register.component';
import { LoginComponent } from './components/login.component';
import { PhotoComponent } from './components/photo.component';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

// import { RegisterService } from './service/register.service';

@NgModule({
  imports: [BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: 'register',
        component: RegisterComponent
      },
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'photo',
        component: PhotoComponent
      }
    ])],
  // providers: [RegisterService],
  declarations: [AppComponent, NavBarComponent, PhotoComponent, HomeComponent, RegisterComponent, SidebarComponent, PhotoListComponent, LoginComponent],
  bootstrap: [AppComponent]
})

export class AppModule { }
