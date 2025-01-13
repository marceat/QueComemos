import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';
import { AuthService } from 'services/auth.service';

@Component({
  selector: 'app-registro',
  standalone: true,
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css'],
  imports: [FormsModule]
})
export class RegistroComponent {
  dni: number;
  nombre: string = '';
  apellido: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';
  preferenciasAlimentarias: string = '';
  rol: string = '';
  fotoPerfil: string;

  constructor(private http: HttpClient, private router: Router, private authService: AuthService) {}

  onFileSelected(event: any) {
    this.fotoPerfil = event.target.files[0];
  }

  onSubmit(formulario: NgForm) {

    if (formulario.valid){
      if (this.password !== this.confirmPassword) {
        alert("Las contraseñas no coinciden.");
        return;
      }

      const usuario = {
        dni: this.dni,
        nombre: this.nombre,
        apellido: this.apellido,
        email: this.email,
        contraseña: this.password,
        preferenciasAlimentarias: this.preferenciasAlimentarias,
        rol: this.rol,
        fotoPerfil: this.fotoPerfil
      };

      const formData = new FormData();
      formData.append('usuario', new Blob([JSON.stringify(usuario)], { type: 'application/json' }));
      //if (this.fotoPerfil) {
      //  formData.append('fotoPerfil', this.fotoPerfil, this.fotoPerfil.name);
      //}

      const usuarioJSON = JSON.stringify(usuario);
      console.log(usuarioJSON);
      this.authService.postUsuario(usuarioJSON);
      

      //this.http.post('/api/usuario/agregar', usuarioJSON)
      //  .subscribe(
      //    (response: any) => {
      //      alert("Registro exitoso: " + response.message);
      //      this.router.navigate(['/login']);
      //    },
      //    error => {
      //      if (error.error && error.error.message) {
      //        alert("Error en el registro: " + error.error.message);
      //      } else {
      //        alert("Error en el registro: " + error.message);
      //      }
      //    }
      //  );
    } else {

    }
<<<<<<< HEAD
=======

    const usuario = {
      dni: this.dni,
      nombre: this.nombre,
      apellido: this.apellido,
      email: this.email,
      contraseña: this.password,
      preferenciasAlimentarias: this.preferenciasAlimentarias,
      rol: this.rol
    };

    const formData = new FormData();
    formData.append('usuario', new Blob([JSON.stringify(usuario)], { type: 'application/json' }));
    if (this.fotoPerfil) {
      formData.append('fotoPerfil', this.fotoPerfil, this.fotoPerfil.name);
    }

    this.http.post('http://localhost:8086/api/usuario_general/agregar', formData).subscribe(
      (response: any) => {
        alert("Registro exitoso: " + response.message);
        this.router.navigate(['/login']);
      },
      error => {
        if (error.error && error.error.message) {
          alert("Error en el registro: " + error.error.message);
        } else {
          alert("Error en el registro: " + error.message);
        }
      }
    );
>>>>>>> branch 'main' of https://github.com/marceat/QueComemos.git
  }
}
