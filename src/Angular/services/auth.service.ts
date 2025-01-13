import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import axios from 'axios';
import { Router } from '@angular/router';
import { UserService } from './user.service';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient, private router: Router, private userService: UserService) {}

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
  }

  isAuthenticated(): boolean {
    return !!localStorage.getItem('token');
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
