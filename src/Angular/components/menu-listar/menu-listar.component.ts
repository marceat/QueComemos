import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Menu } from 'model/menu';
import { MenuService } from '../../services/menu.service'
import { NgIf } from '@angular/common';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import {MatIconModule} from '@angular/material/icon';

@Component({
  selector: 'app-menu-listar',
  templateUrl: './menu-listar.component.html',
  styleUrls: ['./menu-listar.component.css'],
  imports: [FormsModule, NgIf, MatIconModule]
})
export class MenuListarComponent implements OnInit {

  listaMenues: any = [];

  constructor(private menuService: MenuService, private toastr: ToastrService, private router: Router) { }

  ngOnInit() {
    this.menuService.getMenues().then(response => {
      this.listaMenues = response.data;
    });
  }

  onCancel(){
    this.router.navigate(['home']);
  }

  editar(menu: Menu){ 
    this.router.navigate(['menu/editar/', menu.id]);
  }

  eliminar(){

  }

}
