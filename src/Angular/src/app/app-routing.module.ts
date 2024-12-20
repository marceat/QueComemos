import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from '../../components/login/login.component';
import { RegistroComponent } from '../../components/registro/registro.component';
import { HomeComponent } from '../../components/home/home.component';
import { MenuComponent } from 'components/menu-compra/menu-compra.component';
import { MenuEditarComponent } from 'components/menu-editar/menu-editar.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'home', component: HomeComponent },
  { path: 'menu/comprar', component: MenuComponent },
  { path: 'menu/crear', component: MenuComponent },
  { path: 'menu/editar/', component:  MenuEditarComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
