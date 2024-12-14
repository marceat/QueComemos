import { Component } from '@angular/core';
import { Menu } from '../../model/menu';
import { CardMenu } from '../card/card.component';
import axios from 'axios';
import { MenuService } from '../../services/menu.service'

@Component({
  selector: 'app-menu',
  imports: [ CardMenu ],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})

export class MenuComponent {
    listaMenues: any [] = [];

    constructor(private menuService: MenuService) {

    }

    ngOnInit() {
      this.menuService.getMenues().then(response => {
        this.listaMenues = response.data;
        console.log(this.listaMenues);
      });
    }
}


