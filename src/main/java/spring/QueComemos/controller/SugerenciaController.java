package spring.QueComemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import jakarta.validation.Valid;
import spring.QueComemos.model.Sugerencia;
import spring.QueComemos.services.SugerenciaDAOjpa;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/sugerencia", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class SugerenciaController {

    @Autowired
    private SugerenciaDAOjpa sugerenciaService;

    //=========================== OBTENER ===========================
    @GetMapping("/{id}")
    public ResponseEntity<Sugerencia> obtenerSugerenciaPorId(@PathVariable("id") int id) {
        Optional<Sugerencia> sugerenciaObtenida = sugerenciaService.obtenerPorId(id);

        if (!sugerenciaObtenida.isPresent()) {
            System.out.println("Sugerencia con id " + id + " no encontrada.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sugerenciaObtenida.get(), HttpStatus.OK);
    }

    //=========================== LISTAR ===========================
    @GetMapping
    public ResponseEntity<List<Sugerencia>> listarSugerencias() {
        List<Sugerencia> sugerenciasObtenidas = sugerenciaService.listar();

        if (sugerenciasObtenidas.isEmpty()) {
            System.out.println("No se encontraron sugerencias disponibles.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sugerenciasObtenidas, HttpStatus.OK);
    }

    //=========================== AGREGAR ===========================
    @PostMapping("/agregar")
    public ResponseEntity<Sugerencia> crearSugerencia(@Valid @RequestBody Sugerencia sugerencia) {
        System.out.println("Creando la sugerencia: " + sugerencia.getMensaje());
        sugerenciaService.agregar(sugerencia);
        return new ResponseEntity<>(sugerencia, HttpStatus.CREATED);
    }

    //=========================== ACTUALIZAR ===========================
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Sugerencia> actualizarSugerencia(@PathVariable("id") int id, @Valid @RequestBody Sugerencia sugerenciaActualizada) {
        System.out.println("Actualizando la sugerencia con id: " + id);

        Optional<Sugerencia> sugerenciaActual = sugerenciaService.obtenerPorId(id);

        if (!sugerenciaActual.isPresent()) {
            System.out.println("Sugerencia con id:" + id + ", no encontrada.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Sugerencia sugerencia = sugerenciaActual.get();
        sugerencia.setMensaje(sugerenciaActualizada.getMensaje());
        sugerencia.setTipoDeSugerencia(sugerenciaActualizada.getTipoDeSugerencia());
        sugerencia.setUsuario(sugerenciaActualizada.getUsuario());

        sugerenciaService.actualizar(sugerencia);
        return new ResponseEntity<>(sugerencia, HttpStatus.OK);
    }

    //=========================== ELIMINAR ===========================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSugerencia(@PathVariable("id") int id) {
        System.out.println("Obteniendo y eliminando la sugerencia con id: " + id);

        Optional<Sugerencia> sugerenciaObtenida = sugerenciaService.obtenerPorId(id);

        if (!sugerenciaObtenida.isPresent()) {
            System.out.println("No es posible eliminar. Sugerencia con id:" + id + ", no encontrada.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        sugerenciaService.eliminar(sugerenciaObtenida.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //=========================== ELIMINAR TODAS ===========================
    @DeleteMapping
    public ResponseEntity<Void> eliminarTodas() {
        System.out.println("Eliminando todas las sugerencias.");
        sugerenciaService.eliminarTodo();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
