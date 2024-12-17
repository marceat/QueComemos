import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [FormsModule]
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit() {
    const credentials = { username: this.username, password: this.password };
    this.http.post('/api/login', credentials).subscribe(
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
