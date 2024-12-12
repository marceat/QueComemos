package spring.QueComemos.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import spring.QueComemos.model.CartaSemanal;
import spring.QueComemos.services.CartaSemanalDAOjpa;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/cartaSemanal", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CartaSemanalController {

@Autowired
private CartaSemanalDAOjpa cartaSemanalService;

//=========================== OBTENER ===========================
@GetMapping("/{id}")
public ResponseEntity<CartaSemanal> obtenerCartaSemanalPorId(@PathVariable("id") int id) {
   Optional<CartaSemanal> cartaSemanalObtenida = cartaSemanalService.obtenerPorId(id);

   if (!cartaSemanalObtenida.isPresent()) {
	   System.out.println("Carta semanal con id " + id + " no encontrada.");
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
	   return new ResponseEntity<>(cartaSemanalObtenida.get(), HttpStatus.OK);
	}

//=========================== LISTAR ===========================
@GetMapping
public ResponseEntity<List<CartaSemanal>> listarCartasSemanales() {
	 List<CartaSemanal> cartasSemanalesObtenidas = cartaSemanalService.listar();

	 if (cartasSemanalesObtenidas.isEmpty()) {
	     System.out.println("No se encontraron cartas semanales disponibles.");
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	     return new ResponseEntity<>(cartasSemanalesObtenidas, HttpStatus.OK);
	 }

//=========================== AGREGAR ===========================
@PostMapping("/agregar")
public ResponseEntity<CartaSemanal> crearCartaSemanal(@Valid @RequestBody CartaSemanal cartaSemanal) {
	 System.out.println("Creando la carta semanal.");
	 cartaSemanalService.agregar(cartaSemanal);
	 return new ResponseEntity<>(cartaSemanal, HttpStatus.CREATED);
	 }


//=========================== ACTUALIZAR ===========================
@PutMapping("/actualizar/{id}")
public ResponseEntity<CartaSemanal> actualizarCartaSemanal(@PathVariable("id") int id, @Valid @RequestBody CartaSemanal cartaSemanal) {
	System.out.println("Actualizando la carta semanal con id: " + id);

	Optional<CartaSemanal> cartaSemanalActual = cartaSemanalService.obtenerPorId(id);

	if (!cartaSemanalActual.isPresent()) {
	      System.out.println("Carta semanal con id:" + id + ", no encontrada.");
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }

	 CartaSemanal actualCartaSemanal = cartaSemanalActual.get();
	 actualCartaSemanal.setId_menu_lunes_1(cartaSemanal.getId_menu_lunes_1());
	 actualCartaSemanal.setId_menu_lunes_2(cartaSemanal.getId_menu_lunes_2());
	 actualCartaSemanal.setId_menu_martes_1(cartaSemanal.getId_menu_martes_1());
	 actualCartaSemanal.setId_menu_martes_2(cartaSemanal.getId_menu_martes_2());
	 actualCartaSemanal.setId_menu_miercoles_1(cartaSemanal.getId_menu_miercoles_1());
	 actualCartaSemanal.setId_menu_miercoles_2(cartaSemanal.getId_menu_miercoles_2());
	 actualCartaSemanal.setId_menu_jueves_1(cartaSemanal.getId_menu_jueves_1());
	 actualCartaSemanal.setId_menu_jueves_2(cartaSemanal.getId_menu_jueves_2());
	 actualCartaSemanal.setId_menu_viernes_1(cartaSemanal.getId_menu_viernes_1());
	 actualCartaSemanal.setId_menu_viernes_2(cartaSemanal.getId_menu_viernes_2());

	cartaSemanalService.actualizar(actualCartaSemanal);
	return new ResponseEntity<>(actualCartaSemanal, HttpStatus.OK);
	}

//=========================== ELIMINAR ===========================
@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarCartaSemanal(@PathVariable("id") int id) {
	System.out.println("Obteniendo y eliminando la carta semanal con id: " + id);

	Optional<CartaSemanal> cartaSemanalObtenida = cartaSemanalService.obtenerPorId(id);

	if (!cartaSemanalObtenida.isPresent()) {
		System.out.println("No es posible eliminar. Carta semanal con id: " + id + ", no encontrada.");
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	cartaSemanalService.eliminar(cartaSemanalObtenida.get());
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//=========================== ELIMINAR TODAS ===========================
@DeleteMapping
public ResponseEntity<Void> eliminarTodas() {
	System.out.println("Eliminando todas las cartas semanales.");
	cartaSemanalService.eliminarTodo();
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}


