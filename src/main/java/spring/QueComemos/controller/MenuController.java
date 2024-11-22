package spring.QueComemos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.QueComemos.model.Comida;
import spring.QueComemos.services.ComidaDAOjpa;
import spring.QueComemos.services.MenuDAOjpa;
import spring.QueComemos.model.Menu;

@RestController
@RequestMapping(value="/api/menu",produces = {MediaType.APPLICATION_JSON_VALUE})
public class MenuController {
	
	@Autowired
	MenuDAOjpa menuService; 
	
	//================================ OBTENER  =====================================
	@GetMapping("/{id}")
	public ResponseEntity<Menu> obtenerMenuPorId(@PathVariable("id") int id){
		Optional<Menu> menuObtenido = menuService.obtenerPorId(id);
		
		if (!menuObtenido.isPresent()) {
			System.out.println("Comida con id "+id+" no encontrada.");
			return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Menu>(menuObtenido.get(),HttpStatus.OK);
	}
	
	//================================ LISTAR  =====================================
	
	@GetMapping
	public ResponseEntity<List<Menu>> listarMenu(){
		List<Menu> menuesObtenidos = (ArrayList<Menu>) menuService.listar();
		
		if (menuesObtenidos.isEmpty()) {
			System.out.println("No se encontraron comidas disponibles.");
			return new ResponseEntity<List<Menu>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Menu>>(menuesObtenidos,HttpStatus.OK);
	}
	
	//================================ AGREGAR  =====================================
	
	@PostMapping("/agregar")
	public ResponseEntity crearMenu(@RequestBody Menu menu){
		System.out.println("Creando la menu: "+menu.getNombreMenu());
		
		if (menuService.existe(menu.getId())) {
			System.out.println("Ya existe en la base de datos el menu:"+menu.getId()+" - "+menu.getEntrada()+" - $"+
					menu.getPlatoPrincipal()+" - "+menu.getPostre()+" - "+menu.getTipoMenu()+" - "+menu.getPrecio());
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		menuService.agregar(menu);
		return new ResponseEntity<Comida>(HttpStatus.OK);
	}
	
	//================================ ACTUALIZAR  =====================================
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Menu> actualizarMenu(@PathVariable("id") int id, @RequestBody Menu menu){
		System.out.println("Actualizando el menu con id: "+menu.getId());
		
		Optional<Menu> menuActual = menuService.obtenerPorId(id);
		
		if(menuActual == null) {
			System.out.println("Comida con id:"+id+", no encontrada.");
			return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
		}
		
		menuActual.get().setNombreMenu(menu.getNombreMenu());
		menuActual.get().setPlatoPrincipal(menu.getPlatoPrincipal());
		menuActual.get().setEntrada(menu.getEntrada());
		menuActual.get().setBebida(menu.getBebida());
		menuActual.get().setPostre(menu.getPostre());
		menuActual.get().setPrecio(menu.getPrecio());
		menuActual.get().setTipoMenu(menu.getTipoMenu());
		
		menuService.actualizar(menu);
		return new ResponseEntity<Menu>(HttpStatus.OK);
	}
	
	//================================ ELIMINAR   =====================================
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Menu> eliminarMenu(@PathVariable("id") int id){
		System.out.println("Obteniendo y eliminando el menu con id: "+id);
			
		Optional<Menu> menuObtenido = (Optional<Menu>) menuService.obtenerPorId(id);
		
		if(menuObtenido == null) {
			System.out.println("No es posible eliminar. Comida con id:"+id+", no encontrada.");
			return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
		}
			
		menuService.eliminar(menuObtenido.get());
		return new ResponseEntity<Menu>(HttpStatus.NO_CONTENT);
	}
		
	 //================================ ELIMINAR TODAS  =====================================
	@DeleteMapping
	public ResponseEntity<Menu> eliminarTodas(){
		System.out.println("Eliminando todas las comidas.");
		
		menuService.eliminarTodo();
		return new ResponseEntity<Menu>(HttpStatus.NO_CONTENT);
	}

}
