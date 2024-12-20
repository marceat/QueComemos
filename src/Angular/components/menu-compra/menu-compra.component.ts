import { Component } from '@angular/core';
import { Menu } from '../../model/menu';
import { CardMenu } from '../card/card.component';
import axios from 'axios';
import { MenuService } from '../../services/menu.service'
import {MatIconModule} from '@angular/material/icon';

@Component({
  selector: 'app-menu',
  imports: [ CardMenu, MatIconModule ],
  templateUrl: './menu-compra.component.html',
  styleUrl: './menu-compra.component.css'
})

export class MenuComponent {
    listaMenues: Array<Menu> = [];
    listaCarrito: Array<Menu> = [];
    totalCarrito: number = 0;

    constructor(private menuService: MenuService) {
      
    }

    sumarUnoCantidadExistenteCarrito(menu: Menu) {
      let menuEncontrado: Menu;
      menuEncontrado = this.listaCarrito.find(item => item.id == menu.id); //Lo encuentro y obtengo.
      this.listaCarrito = this.listaCarrito.filter(item => item.id !== menu.id); //Lo saco del array
      menuEncontrado.cantidad ++;  
      this.listaCarrito.push(menuEncontrado);

      this.actualizarPrecioTotalCarrito();
      
    }

    restarUnoCantidadExistenteCarrito(menu: Menu) {
      let menuEncontrado: Menu;
      menuEncontrado = this.listaCarrito.find(item => item.id == menu.id); //Lo encuentro y obtengo.
      if (menuEncontrado.cantidad != 0) {
        this.listaCarrito = this.listaCarrito.filter(item => item.id !== menu.id); //Lo saco del array
        menuEncontrado.cantidad --;  
        this.listaCarrito.push(menuEncontrado);
        this.totalCarrito = this.totalCarrito - menu.precio;

        this.actualizarPrecioTotalCarrito();
        
      }
    }

    eliminarDelCarrito(menu: Menu): void {
      let menuEncontrado: Menu;
      this.listaCarrito = this.listaCarrito.filter(item => item.id !== menu.id); //Lo saco del array

      
      this.actualizarPrecioTotalCarrito();
      
    }

    agregarAlCarrito(menu: Menu): void{
      
      if(this.existeEnElCarrito(menu)){
        let menuEncontrado: Menu;
        menuEncontrado = this.listaCarrito.find(item => item.id == menu.id); //Lo encuentro y obtengo.
        this.listaCarrito = this.listaCarrito.filter(item => item.id !== menu.id); //Lo saco del array
        menuEncontrado.cantidad ++;
        this.listaCarrito.push(menuEncontrado);
      } else {
        menu.cantidad = 1;
        this.listaCarrito.push(menu);
        
      }
      
      this.actualizarPrecioTotalCarrito();
    }
    
    existeEnElCarrito(menu: Menu): boolean {
      return this.listaCarrito.includes(menu);
    }

    actualizarPrecioTotalCarrito(){
       //Reseteo el total del carrito, y lo vuelvo a setear recorriendo los items.
      this.totalCarrito=0;
      this.listaCarrito.forEach(item => this.totalCarrito=this.totalCarrito+(item.cantidad * item.precio));
      this.listaCarrito = this.listaCarrito.sort();
    }

    ngOnInit() {
      this.menuService.getMenues().then(response => {
        this.listaMenues = response.data;
        console.log(this.listaMenues);
      });
    }
}


