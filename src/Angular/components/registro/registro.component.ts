import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms'; // debo importar FormsModule

@Component({
  selector: 'app-registro',
  standalone: true,
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css'],
  imports: [HttpClientModule, FormsModule] // Incluir FormsModule acá
})
export class RegistroComponent {
  username: string = '';
  password: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit() {
    this.http.post('/api/registro', { username: this.username, password: this.password }).subscribe(response => {
      this.router.navigate(['/login']);
    });
  }
}
