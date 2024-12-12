package spring.QueComemos.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
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
	
	@PostMapping("/agregar") //ResponseEntity<Comida>
	public ResponseEntity<String> crearComida(@Valid @RequestBody Comida comida){
		try {
			if (comidaService.existe(comida.getId())) {
				System.out.println("Ya existe en la base de datos la comida id:"+comida.getId()+" - "+comida.getNombre()+" - $"+
				comida.getPrecio()+" - "+comida.getStock());
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe esa comida con ese id");
			}
			comidaService.agregar(comida);
			return ResponseEntity.status(HttpStatus.CREATED).body("Comida agregada con éxito.");
		} catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor: " + e.getMessage());
        }
		//return new ResponseEntity<Comida>(HttpStatus.CREATED);
	}
	
	//================================ ACTUALIZAR  =====================================
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<String> actualizarComida(@Valid @PathVariable("id") int id, @RequestBody Comida unaComida){
		
		try {
		
			Optional<Comida> comidaActual = comidaService.obtenerPorId(id);
			
			if(comidaActual == null) {
				System.out.println("Comida con id:"+id+", no encontrada.");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra una comida con el id ingresado.");
			}
			
			comidaActual.get().setNombre(unaComida.getNombre());
			comidaActual.get().setPrecio(unaComida.getPrecio());
			comidaActual.get().setStock(unaComida.getStock());
			
			comidaService.actualizar(comidaActual.get());
			return ResponseEntity.status(HttpStatus.OK).body("Comida actualizada con éxito.");
		} catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor: " + e.getMessage());
        }
	}
	
	//================================ ELIMINAR   =====================================
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarComida(@PathVariable("id") int id){
		
		try {
			
			Optional<Comida> comidaObtenida = comidaService.obtenerPorId(id);
				
			if(comidaObtenida == null) {
				System.out.println("No es posible eliminar. Comida con id:"+id+", no encontrada.");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra una comida con el id ingresado.");
			}
				
			comidaService.eliminar(comidaObtenida.get());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comida con id "+id+" borrada con éxito.");
		} catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
		
	 //================================ ELIMINAR TODAS  =====================================
	@DeleteMapping
	public ResponseEntity<String> eliminarTodas(){
		System.out.println("Eliminando todas las comidas.");
		
		comidaService.eliminarTodo();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se han eliminado todas las comidas.");
	}
	
	

}
