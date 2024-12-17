import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [FormsModule,RouterModule]
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit() {
    const credentials = { email: this.email, password: this.password };
    this.http.post('http://localhost:8080/api/login', credentials).subscribe( // Asegúrate de que la URL del backend sea correcta
      (response: any) => {
        alert("Inicio de sesión exitoso");
        this.router.navigate(['/home']);
      },
      error => {
        if (error.error && error.error.message) {
          alert("Error en el inicio de sesión: " + error.error.message);
        } else {
          alert("Error en el inicio de sesión: " + error.message);
        }
      }
    );
  }
}
