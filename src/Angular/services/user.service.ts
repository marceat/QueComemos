import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
  })
export class UserService {

  public current_user: string;
  public user_logged_status: boolean = false;

  public is_logged(){
    return this.user_logged_status;
  }

  public sessionIn(user){
    this.user_logged_status = true;
    this.current_user = user;
    console.log("ha iniciado sesión el usuario: "+this.current_user);
  }

  public log_out(){
    this.current_user = null;
    this.user_logged_status = false;
    console.log(this.current_user);
  }

constructor() { }


}
