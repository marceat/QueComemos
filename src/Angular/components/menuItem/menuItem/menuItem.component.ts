import { FlatTreeControl } from '@angular/cdk/tree';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-menuItem',
  templateUrl: './menuItem.component.html',
  styleUrls: ['./menuItem.component.css']
})
export class MenuItemComponent implements OnInit {

  //@Input({required: true}) public id: number = 0;
  @Input({required: true}) public nombreMenu: String = '';
  @Input({required: true}) public entrada: String = '';
  @Input({required: true}) public platoPrincipal: String = '';
  @Input({required: true}) public bebida: String = '';
  @Input({required: true}) public postre: String = '';
  @Input({required: true}) public precio: number = 0;

  constructor() { }

  ngOnInit() {
  }

}