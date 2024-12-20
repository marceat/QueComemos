import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AuthService } from 'services/auth.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [FormsModule]
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
      console.log(this.authService.login(credentialsJSON));
      this.usuarioLogeado = (await (this.authService.getUsuario(credentials.dni))).data;
      this.toastSucess();
      //console.log("daleeeeeeeeeeee", this.usuarioLogeado);
    } else {
      this.toastError();
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

  toastError(){
    this.toastr.clear();
    this.toastr.error("", 'ERROR');
  }
}
