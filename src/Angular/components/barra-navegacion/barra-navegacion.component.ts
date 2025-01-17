import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from 'services/session.service';

@Component({
  selector: 'app-barra-navegacion',
  templateUrl: './barra-navegacion.component.html',
  styleUrls: ['./barra-navegacion.component.css']
})
export class BarraNavegacionComponent implements OnInit {

  nombre;

  constructor(private router: Router) { }

  ngOnInit() {
    this.actualizarDatosSession();
  }

  actualizarDatosSession(){
    try {
      this.nombre = localStorage.getItem('nombre');
    console.log("barra-navegacion - nombre"+this.nombre);
    } catch (error) {
     
    console.log("barra-navegacion - no se pudo chango");
    }
    
  }

  onClickLogin(){
    this.router.navigate(['login']);
  }

}
