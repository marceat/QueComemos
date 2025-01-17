import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule, NgIf } from '@angular/common';
import { LoginComponent } from 'components/login/login.component';
import { BarraNavegacionComponent } from 'components/barra-navegacion/barra-navegacion.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, CommonModule, NgIf, BarraNavegacionComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {

  constructor (){
    
  }


}


