import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { MatIcon, MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-barra-navegacion',
  templateUrl: './barra-navegacion.component.html',
  styleUrls: ['./barra-navegacion.component.css'],
  imports: [MatIconModule],
})
export class BarraNavegacionComponent implements OnInit {

  nombre: string;
  estado_session: string

  constructor(private router: Router) { }

  ngOnInit() {
    this.nombre = localStorage.getItem('nombre');
    this.estado_session = localStorage.getItem('estado_session');
    //console.log(this.nombre);
    //console.log(this.estado_session);
    
  }


  actualizarDatosSession(){
      this.nombre = localStorage.getItem('nombre');
      this.estado_session = localStorage.getItem('estado_session');
      //console.log("barra-navegacion - nombre: "+this.nombre);
      window.location.reload();
  }

  logout(){
    localStorage.setItem('nombre', null);
    localStorage.setItem('estado_session', 'no logeado');
    //console.log("Cierre de sesión.");
    window.location.reload();
    this.router.navigate(['home']);
  }

  onClickLogin(){
    this.router.navigate(['login']);
  }

  onClickRegister(){
    this.router.navigate(['registro']);
  }

}
