import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registro',
  templateUrl: 'registro.component.html',
  styleUrls: ['registro.component.css']
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
