import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-registro',
  standalone: true,
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css'],
  imports: [FormsModule]
})
export class RegistroComponent {
  dni: number = 0;
  nombre: string = '';
  apellido: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';
  preferenciasAlimentarias: string = '';
  rol: string = '';
  fotoPerfil: File | null = null;

  constructor(private http: HttpClient, private router: Router) {}

  onFileSelected(event: any) {
    this.fotoPerfil = event.target.files[0];
  }

  onSubmit() {
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
      rol: this.rol
    };

    const formData = new FormData();
    formData.append('usuario', new Blob([JSON.stringify(usuario)], { type: 'application/json' }));
    if (this.fotoPerfil) {
      formData.append('fotoPerfil', this.fotoPerfil, this.fotoPerfil.name);
    }

    this.http.post('/api/usuario/agregar', formData).subscribe(
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
  }
}
