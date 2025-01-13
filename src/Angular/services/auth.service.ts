import { HttpClient } from '@angular/common/http';
<<<<<<< HEAD
import axios from 'axios';
import { Router } from '@angular/router';
import { UserService } from './user.service';

=======
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
>>>>>>> branch 'main' of https://github.com/marceat/QueComemos.git

@Injectable({
  providedIn: 'root'
})
export class AuthService {
<<<<<<< HEAD
  constructor(private http: HttpClient, private router: Router, private userService: UserService) {}
=======
  private apiUrl = 'http://localhost:8086/api';

  constructor(private http: HttpClient) {}
>>>>>>> branch 'main' of https://github.com/marceat/QueComemos.git

<<<<<<< HEAD
  //login(username: string, password: string) {
  //  return this.http.post('/api/login', { username, password });
  //}

  login(usuarioJSON): Promise<any>{
      //console.log(usuarioJSON['nombre']);
      return axios.post('http://localhost:8086/api/login', usuarioJSON, {
        headers: {
            'Content-Type': 'application/json',
        }
        
      }).then((response: any) => {
          this.router.navigate(['home']);
      });
=======
  login(username: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, { username, password });
  }

  setToken(token: string): void {
    localStorage.setItem('token', token);
  }

  getToken(): string | null {
    return localStorage.getItem('token');
>>>>>>> branch 'main' of https://github.com/marceat/QueComemos.git
  }

  isAuthenticated(): boolean {
    return !!this.getToken();
  }

  postUsuario(usuarioJSON){
    axios.post('http://localhost:8086/api/usuario/agregar', usuarioJSON, {
      headers: {
          'Content-Type': 'application/json',
      }
    }).then((response: any) => {
        
        this.router.navigate(['home']);
        error => {
          if (error.error && error.error.message) {
            alert("Error en el registro: " + error.error.message);
          }
        }
    });
  }

  getUsuario(dni: number) {
    return axios.get('http://localhost:8086/api/usuario/'+dni);
  }

}
