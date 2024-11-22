package spring.QueComemos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.QueComemos.model.*;

import spring.QueComemos.services.ComidaDAOjpa;

@RestController
@RequestMapping(value="/api/comida",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ComidaController {
	
	@Autowired
	ComidaDAOjpa comidaService; 
	
	//================================ OBTENER  =====================================
	
	@GetMapping("/{id}")
	public ResponseEntity<Comida> obtenerComidaPorId(@PathVariable("id") int id){
		Optional<Comida> comidaObtenida = comidaService.obtenerPorId(id);
		
		if (comidaObtenida == null) {
			System.out.println("Comida con id "+id+" no encontrada.");
			return new ResponseEntity<Comida>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Comida>(comidaObtenida.get(),HttpStatus.OK);
	}
	
	//================================ LISTAR  =====================================
	
	@GetMapping
	public ResponseEntity<List<Comida>> listarComidas(){
		List<Comida> comidasObtenidas = (ArrayList<Comida>) comidaService.listar();
		
		if (comidasObtenidas.isEmpty()) {
			System.out.println("No se encontraron comidas disponibles.");
			return new ResponseEntity<List<Comida>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Comida>>(comidasObtenidas,HttpStatus.OK);
	}
	
	//================================ AGREGAR  =====================================
	
	@PostMapping("/agregar")
	public ResponseEntity crearComida(@RequestBody Comida comida){
		System.out.println("Creando la comida: "+comida.getNombre());
		
		if (comidaService.existe(comida.getId())) {
			System.out.println("Ya existe en la base de datos la comida id:"+comida.getId()+" - "+comida.getNombre()+" - $"+
			comida.getPrecio()+" - "+comida.getStock());
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		comidaService.agregar(comida);
		return new ResponseEntity<Comida>(HttpStatus.OK);
	}
	
	//================================ ACTUALIZAR  =====================================
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Comida> actualizarComida(@PathVariable("id") int id, @RequestBody Comida unaComida){
		System.out.println("Actualizando la comida con id: "+unaComida.getId());
		
		Optional<Comida> comidaActual = comidaService.obtenerPorId(id);
		
		if(comidaActual == null) {
			System.out.println("Comida con id:"+id+", no encontrada.");
			return new ResponseEntity<Comida>(HttpStatus.NOT_FOUND);
		}
		
		comidaActual.get().setNombre(unaComida.getNombre());
		comidaActual.get().setPrecio(unaComida.getPrecio());
		comidaActual.get().setStock(unaComida.getStock());
		
		comidaService.actualizar(comidaActual.get());
		return new ResponseEntity<Comida>(HttpStatus.OK);
	}
	
	//================================ ELIMINAR   =====================================
	@DeleteMapping("/{id}")
	public ResponseEntity<Comida> eliminarComida(@PathVariable("id") int id){
		System.out.println("Obteniendo y eliminando la comida con id: "+id);
			
		Optional<Comida> comidaObtenida = comidaService.obtenerPorId(id);
			
		if(comidaObtenida == null) {
			System.out.println("No es posible eliminar. Comida con id:"+id+", no encontrada.");
			return new ResponseEntity<Comida>(HttpStatus.NOT_FOUND);
		}
			
		comidaService.eliminar(comidaObtenida.get());
		return new ResponseEntity<Comida>(HttpStatus.NO_CONTENT);
	}
		
	 //================================ ELIMINAR TODAS  =====================================
	@DeleteMapping
	public ResponseEntity<Comida> eliminarTodas(){
		System.out.println("Eliminando todas las comidas.");
		
		comidaService.eliminarTodo();
		return new ResponseEntity<Comida>(HttpStatus.NO_CONTENT);
	}
	
	

}
