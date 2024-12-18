
import { CurrencyPipe, NgOptimizedImage } from '@angular/common';
import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output, OnInit } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import { Menu } from 'model/menu';

/**
 * @title Card with multiple sections
 */
@Component({
  selector: 'card-menu',
  templateUrl: './card.component.html',
  styleUrl: './card.component.css',
  imports: [MatCardModule, MatButtonModule, NgOptimizedImage, MatIconModule],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CardMenu implements OnInit {
  @Input({required: true}) public id: number = 0;
  @Input({required: true}) public nombreMenu: String = '';
  @Input({required: true}) public entrada: String = '';
  @Input({required: true}) public platoPrincipal: String = '';
  @Input({required: true}) public bebida: String = '';
  @Input({required: true}) public postre: String = '';
  @Input({required: true}) public tipoMenu: String = '';
  @Input({required: true}) public precio: number = 0;
  @Input({required: true}) public image: String = '';

  menu;

  constructor(){

  }


  //Emito una función, y el componente padre (Menu) deberá suscribirse a ésta para escucharla y obtener el dato. 
  @Output() agregarMenuAlCarrito: EventEmitter<Menu> = new EventEmitter<Menu>();

  public agregar(): void {
    this.agregarMenuAlCarrito.emit(this.menu);
  }

  ngOnInit(): void {
    this.menu = new Menu(this.id,this.nombreMenu,this.entrada,this.platoPrincipal,this.bebida,this.postre,this.precio,this.tipoMenu,this.image);
  }
}
