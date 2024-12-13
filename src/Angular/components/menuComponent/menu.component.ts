import { Component } from '@angular/core';
import { Menu } from '../../model/menu';
import { CardMenu } from '../card/card.component';
import axios from 'axios';
import { MenuService } from '../../services/menu.service';

@Component({
  selector: 'app-menu',
  imports: [ CardMenu ],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})

export class MenuComponent {
    listaMenues: any [] = [];
    // [
      //{'id':1,'nombreMenu':'Menú Vegetariano', 'entrada':'Empanada vegana','platoPrincipal':'Ensalada césar','bebida':'pepsi','tipoMenu': 'No vegetariano','postre':'manzana','precio':4500},
      //{'id':1,'nombreMenu':'Menú Vegetariano', 'entrada':'Empanada vegana','platoPrincipal':'Ensalada césar','bebida':'pepsi','tipoMenu': 'No vegetariano','postre':'manzana','precio':4500},
    //];

    constructor(private menuService: MenuService) {

    }

    ngOnInit() {
      this.menuService.getMenues().then(response => {
        this.listaMenues = response.data;
        console.log(this.listaMenues);
      });
    }
}


