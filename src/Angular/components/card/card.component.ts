
import { NgOptimizedImage } from '@angular/common';
import {ChangeDetectionStrategy, Component, Input, OnInit } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';

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
  @Input({required: true}) public nombreMenu: String = '';
  @Input({required: true}) public entrada: String = '';
  @Input({required: true}) public platoPrincipal: String = '';
  @Input({required: true}) public bebida: String = '';
  @Input({required: true}) public postre: String = '';
  @Input({required: true}) public tipoMenu: String = '';
  @Input({required: true}) public precio: number = 0;
  @Input({required: true}) public image: String = '';

  constructor(){

  }

  ngOnInit(): void {
    
  }
}
