import { Component } from '@angular/core';
<<<<<<< HEAD
import { RouterModule } from '@angular/router';
import { CommonModule, NgIf } from '@angular/common';
import { UserService } from 'services/user.service';
import { LoginComponent } from 'components/login/login.component';
=======
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
>>>>>>> branch 'main' of https://github.com/marceat/QueComemos.git

@Component({
  selector: 'app-root',
<<<<<<< HEAD
  standalone: true,
  imports: [RouterModule, CommonModule, NgIf ],
=======
>>>>>>> branch 'main' of https://github.com/marceat/QueComemos.git
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  imports: [CommonModule, RouterModule]  
})
export class AppComponent {
<<<<<<< HEAD

  
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
=======
  title = 'angular-app';
>>>>>>> branch 'main' of https://github.com/marceat/QueComemos.git
}


