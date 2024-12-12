import { Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { MenuComponent } from '../../components/menuComponent/menu.component';

export const routes: Routes = [
    {path: 'menu/listar', component: MenuComponent},
];
