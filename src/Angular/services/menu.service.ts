import { Injectable } from '@angular/core';
import axios from 'axios';
import { Router } from '@angular/router';
import { Menu } from 'model/menu';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  menu: Menu = new Menu(0,'','','','','',0,'','');

  headers = {
    'Content-Type': 'application/json' 
  }

  constructor(private router: Router) { }

  getMenu(id: Number) {
    return axios.get('http://localhost:8086/api/menu/'+id); //.then((response: any) => {
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


    putMenu(menuJSON, id: Number){
      axios.put('http://localhost:8086/api/menu/actualizar/'+id, menuJSON, {
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
