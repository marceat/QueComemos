package spring.QueComemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import spring.QueComemos.model.Comida;
import spring.QueComemos.services.ComidaDAOjpa;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/comida", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class ComidaController {

    @Autowired
    private ComidaDAOjpa comidaService;

    //=========================== OBTENER ===========================
    @GetMapping("/{id}")
    public ResponseEntity<Comida> obtenerComidaPorId(@PathVariable("id") int id) {
        Optional<Comida> comidaObtenida = comidaService.obtenerPorId(id);

        if (!comidaObtenida.isPresent()) {
            System.out.println("Comida con id " + id + " no encontrada.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comidaObtenida.get(), HttpStatus.OK);
    }

    //=========================== LISTAR ===========================
    @GetMapping
    public ResponseEntity<List<Comida>> listarComidas() {
        List<Comida> comidasObtenidas = comidaService.listar();

        if (comidasObtenidas.isEmpty()) {
            System.out.println("No se encontraron comidas disponibles.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(comidasObtenidas, HttpStatus.OK);
    }

    //=========================== AGREGAR ===========================
    @PostMapping("/agregar")
    public ResponseEntity<Comida> crearComida(@Valid @RequestBody Comida comida) {
        System.out.println("Creando la comida: " + comida.getNombre());

        if (comidaService.existe(comida.getId())) {
            System.out.println("Ya existe en la base de datos la comida con id: " + comida.getId());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        comidaService.agregar(comida);
        return new ResponseEntity<>(comida, HttpStatus.CREATED);
    }

    //=========================== ACTUALIZAR ===========================
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Comida> actualizarComida(@PathVariable("id") int id, @Valid @RequestBody Comida comida) {
        System.out.println("Actualizando la comida con id: " + id);

        Optional<Comida> comidaActual = comidaService.obtenerPorId(id);

        if (!comidaActual.isPresent()) {
            System.out.println("Comida con id: " + id + ", no encontrada.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Comida actualComida = comidaActual.get();
        actualComida.setNombre(comida.getNombre());
        actualComida.setPrecio(comida.getPrecio());
        actualComida.setStock(comida.getStock());

        comidaService.actualizar(actualComida);
        return new ResponseEntity<>(actualComida, HttpStatus.OK);
    }

    //=========================== ELIMINAR ===========================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComida(@PathVariable("id") int id) {
        System.out.println("Obteniendo y eliminando la comida con id: " + id);

        Optional<Comida> comidaObtenida = comidaService.obtenerPorId(id);

        if (!comidaObtenida.isPresent()) {
            System.out.println("No es posible eliminar. Comida con id: " + id + ", no encontrada.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        comidaService.eliminar(comidaObtenida.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //=========================== ELIMINAR TODAS ===========================
    @DeleteMapping
    public ResponseEntity<Void> eliminarTodas() {
        System.out.println("Eliminando todas las comidas.");
        comidaService.eliminarTodo();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

