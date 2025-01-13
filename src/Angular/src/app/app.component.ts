import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule, NgIf } from '@angular/common';
import { UserService } from 'services/user.service';
import { LoginComponent } from 'components/login/login.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, CommonModule, NgIf ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {

  
  current_user = null;
  user_logged_status;

  constructor (private userService: UserService){
    
  }

  ngOnInit() {
    this.current_user = this.userService.current_user;
    this.user_logged_status = this.userService.is_logged();
    console.log("app.component.ts - current user: "+this.current_user);
  }

  logout(){
    this.userService.log_out();
    this.current_user = this.userService.current_user;
    this.user_logged_status = this.userService.is_logged();
  }
}


