import { Component, input, OnInit} from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Menu } from 'model/menu';
import { MenuService } from '../../services/menu.service'
import { NgIf } from '@angular/common';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { MatIcon, MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-menu-editar',
  templateUrl: './menu-editar.component.html',
  styleUrls: ['./menu-editar.component.css'],
  imports: [FormsModule, NgIf, MatIconModule]
})
export class MenuEditarComponent implements OnInit {

   nombreMenu: String;
   entrada: String;
   platoPrincipal: String;
   postre: String;
   bebida: String;
   tipoMenu: String;
   precio: Number;
   image: String;

   id: any;
 
   constructor(private menuService: MenuService, private toastr: ToastrService, private router: Router, private route: ActivatedRoute) { }
 
   onSubmit(formulario: NgForm) { 
 
     if(formulario.valid){
       const menu = {
         nombreMenu: this.nombreMenu,
         entrada: this.entrada,
         platoPrincipal: this.platoPrincipal,
         postre: this.postre,
         bebida: this.bebida,
         tipoMenu: this.tipoMenu,
         precio: this.precio,
         image: this.image,
       };
 
       //¿Y si el menu no se trae bien los datos del formulario? tira bad request, como si el menu no tuviese nada.
 
       const formData = new FormData();
       formData.append('menu', new Blob([JSON.stringify(menu)], { type: 'application/json' }));
 
       const menuJSON = JSON.stringify(menu);
 
       //console.log(menuJSON);
 
       this.menuService.postMenu(menuJSON);
       this.resetearFormulario();
       this.toastSucess();
     } else {
       this.toastError();
     }
     
   }
 
   toastSucess(){
     this.toastr.clear();
     this.toastr.success("Menu cargado con éxito!.", 'COMPLETADO!');
   }
 
   toastError(){
     this.toastr.clear();
     this.toastr.error("Falta completar campos obligatorios", 'ERROR');
   }
 
   resetearFormulario(){
     this.nombreMenu="";
     this.platoPrincipal="";
     this.bebida="";
     this.postre="";
     this.precio=0;
     this.entrada="";
     this.image="";
     this.tipoMenu="";
   }
 
   onCancel(){
     this.router.navigate(['home']);
   }

   obtenerMenu(id: any){
      this.menuService.getMenu(id);
   }
 
   ngOnInit():void {
    //primero obtengo el id, recibido por parámetro.
    this.id=this.route.snapshot.paramMap.get('id');
    this.obtenerMenu(this.id);
    


     //console.log("ACÁ ESTÁ EL ID: "+this.route.snapshot.paramMap.get('id'));
   }
 
 }
 
