import { enableProdMode, importProvidersFrom } from '@angular/core';
import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { environment } from './environments/environment.prod'; 
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { provideAnimations } from '@angular/platform-browser/animations';

import { provideToastr } from 'ngx-toastr';

if (environment.production) {
  enableProdMode();
}

bootstrapApplication(AppComponent, {
  providers: [
    importProvidersFrom(FormsModule, RouterModule),
    provideRouter([
      { path: '', redirectTo: '/login', pathMatch: 'full' },
      { path: 'login', loadComponent: () => import('../components/login/login.component').then(m => m.LoginComponent) },
      { path: 'registro', loadComponent: () => import('../components/registro/registro.component').then(m => m.RegistroComponent) },
      { path: 'home', loadComponent: () => import('../components/home/home.component').then(m => m.HomeComponent) },
      { path: 'menu/comprar', loadComponent: () => import('../components/menu-compra/menu-compra.component').then(m => m.MenuComponent) },
      { path: 'menu/crear', loadComponent: () => import('../components/menu-crear/menu-crear.component').then(m => m.MenuCrearComponent) },
      { path: 'menu/listar', loadComponent: () => import('../components/menu-listar/menu-listar.component').then(m => m.MenuListarComponent) },
      { path: 'menu/editar/:id', loadComponent: () => import('../components/menu-editar/menu-editar.component').then(m => m.MenuEditarComponent) },
    ]),
    provideAnimations(),
    provideToastr(),
    provideHttpClient()
  ]
}).catch(err => console.error(err));
