import { Component } from '@angular/core';
import { Menu } from '../../model/menu';
import { MenuItemComponent } from '../menuItem/menuItem/menuItem.component';
import axios from 'axios';

@Component({
  selector: 'app-menu',
  imports: [ MenuItemComponent ],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})

export class MenuComponent {
    listaMenues: any [] = [
      {'id':1,'nombreMenu':'Menú Vegetariano', 'entrada':'Empanada vegana','platoPrincipal':'Ensalada césar','bebida':'pepsi','tipoMenu': 'No vegetariano','postre':'manzana','precio':4500},
      {'id':1,'nombreMenu':'Menú Vegetariano', 'entrada':'Empanada vegana','platoPrincipal':'Ensalada césar','bebida':'pepsi','tipoMenu': 'No vegetariano','postre':'manzana','precio':4500},
    ];

    async getMenus(){
      try {
        const response = await axios.get('http://localhost:8086/api/menu');
        this.listaMenues = response.data;
        console.log(response.data);
      } catch (error) {
        console.log(error);
      }
    }
}


