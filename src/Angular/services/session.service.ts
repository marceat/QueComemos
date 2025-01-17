import { Injectable } from '@angular/core';
import { BarraNavegacionComponent } from 'components/barra-navegacion/barra-navegacion.component';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private barraNavegacion: BarraNavegacionComponent) { }

  ngOnInit() {
    localStorage.setItem('nombre', null);
  }

  new_session(username){
    localStorage.setItem('nombre', username);
    this.barraNavegacion.actualizarDatosSession;
  }

  getName(){
    return localStorage.getItem('nombre');
  }

  logout(){
    localStorage.setItem('nombre', null);
    this.barraNavegacion.actualizarDatosSession;
  }

}
