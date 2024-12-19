import { enableProdMode, importProvidersFrom } from '@angular/core';
import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { environment } from './environments/environment.prod'; 
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

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
    ]),
    provideHttpClient()
  ]
}).catch(err => console.error(err));
