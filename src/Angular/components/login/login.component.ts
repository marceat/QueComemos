import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AuthService } from 'services/auth.service';
import { ToastrService } from 'ngx-toastr';
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

  constructor(private http: HttpClient, private router: Router, private authService: AuthService, private toastr: ToastrService) {}


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
      //console.log(this.authService.login(credentialsJSON));

      //Obtengo el usuario entero en formato json, al cual acceder con los campos asi:  usuarioLogeado['nombre'] 
      this.usuarioLogeado = (await (this.authService.getUsuario(credentials.dni))).data;
      
      //----------- ACTUALIZO LA INFORMACIÓN DE LA "SESION" ---------------------//
      localStorage.setItem('nombre', (await this.authService.getUsuario(credentials.dni)).data['nombre']);
      localStorage.setItem('estado_session', 'logeado');
      //console.log("REVISANDO LOCALSTORAGE 'login.component.ts'- USUARIO:"+localStorage.getItem('nombre'));
      //--------------------------------------------------------------------------

      if(this.usuarioLogeado.nombre!=null){
        window.location.reload();
        this.router.navigate(['home']);
        this.toastSucess();
      } else {
        this.toastError("Usuario incorrecto.");
      }

      
      
    } else {
      this.toastError("Error.");
    }
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
