import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [FormsModule, RouterModule]
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    this.authService.login(this.email, this.password).subscribe(
      (response: any) => {
        this.authService.setToken(response.token);
        alert("Inicio de sesión exitoso");
        this.router.navigate(['/home']);
      },
      error => {
        console.error('Error en el inicio de sesión', error);
        if (error.error && error.error.message) {
          alert("Error en el inicio de sesión: " + error.error.message);
        } else {
          alert("Error en el inicio de sesión: " + error.message);
        }
      }
    );
  }
}
