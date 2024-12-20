import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private toastr: ToastrService, private router: Router) { }

  goMenuComprar(){
    this.router.navigate(['menu/comprar']);
  }

  goMenuCrear(){
    this.router.navigate(['menu/crear']);
  }

  goMenuListar(){
    this.router.navigate(['menu/listar']);
  }


}
