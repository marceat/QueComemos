import { Injectable } from '@angular/core';
import axios from 'axios';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  headers = {
    'Content-Type': 'application/json' 
  }

  constructor(private router: Router) { }

  getMenu(id) {
    return axios.get('http://localhost:8086/api/menu/',id).then((response: any) => {
      console.log(response.data);
    });
  }

  getMenues() {
    return axios.get('http://localhost:8086/api/menu');
  }

  postMenu(menuJSON){
      axios.post('http://localhost:8086/api/menu/agregar', menuJSON, {
        headers: {
            'Content-Type': 'application/json',
        }
      }).then((response: any) => {
          
          this.router.navigate(['menu/crear']);
          error => {
            if (error.error && error.error.message) {
              alert("Error en el registro: " + error.error.message);
            }
          }
      });
    }
      //---------------------------------------------
       
      

      //----------------------------------------------

 
}
