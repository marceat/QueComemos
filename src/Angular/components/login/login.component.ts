import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AuthService } from 'services/auth.service';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'services/user.service';
import { RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [FormsModule, RouterModule]
})
export class LoginComponent {

  username: number;
  password: string = '';

  usuarioLogeado;

  constructor(private http: HttpClient, private router: Router, private authService: AuthService, private toastr: ToastrService, private userService: UserService) {}


  async onSubmit() {
    
    //const credentials = { username: this.username, password: this.password };
    const credentials = { 
      dni: this.username, 
      nombre: '', 
      apellido: '', 
      email: '', 
      contraseña: this.password, 
      preferenciasAlimentarias: '', 
      rol: '', 
      fotoPerfil: ''}

    let credentialsJSON = JSON.stringify(credentials);
    if(this.authService.login(credentialsJSON)){
      console.log(this.authService.login(credentialsJSON));

      //Obtengo el usuario entero en formato json, al cual acceder con los campos asi:  usuarioLogeado['nombre'] 
      //this.usuarioLogeado = (await (this.authService.getUsuario(credentials.dni))).data;
      localStorage.setItem('nombre', (await this.authService.getUsuario(credentials.dni)).data);
      console.log("REVISANDO LOCALSTORAGE - USUARIO:"+localStorage.getItem('nombre'));

      //console.log(this.usuarioLogeado['nombre']);

      //----------- ACTUALIZO LA INFORMACIÓN DE LA "SESION" ---------------------//
      this.userService.sessionIn(this.usuarioLogeado['nombre']);
      //console.log(this.userService.current_user);
      //--------------------------------------------------------------------------
     

      if(this.usuarioLogeado.nombre!=null){
        

        this.toastSucess();
      } else {
        this.toastError("Usuario incorrecto.");
      }
      
    } else {
      this.toastError("Error.");
    }


    //this.http.post('/api/login', credentialsJSON).subscribe(
    //  (response: any) => {
    //    alert("Inicio de sesión exitoso");
    //    this.router.navigate(['/home']);
    //  },
    //  error => {
    //    if (error.error && error.error.message) {
    //      alert("Error en el inicio de sesión: " + error.error.message);
    //    } else {
    //      alert("Error en el inicio de sesión: " + error.message);
    //    }
      //}
    //);
  }

  toastSucess(){
    this.toastr.clear();
    this.toastr.success("Usuario logeado exitosamente!.", 'ÉXITO!');
  }

  toastError(mensaje: string){
    this.toastr.clear();
    this.toastr.error(mensaje, 'ERROR');
  }
}
