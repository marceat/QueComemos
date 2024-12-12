package spring.QueComemos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import spring.QueComemos.model.Venta;
import spring.QueComemos.services.VentaDAOjpa;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/venta", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class VentaController {

	@Autowired
	private VentaDAOjpa ventaService;

    //=========================== OBTENER ===========================
    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable("id") int id) {
        Optional<Venta> ventaObtenida = ventaService.obtenerPorId(id);

        if (!ventaObtenida.isPresent()) {
            System.out.println("Venta con id " + id + " no encontrada.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ventaObtenida.get(), HttpStatus.OK);
    }

    //=========================== LISTAR ===========================
    @GetMapping
    public ResponseEntity<List<Venta>> listarVentas() {
        List<Venta> ventasObtenidas = ventaService.listar();

        if (ventasObtenidas.isEmpty()) {
            System.out.println("No se encontraron ventas disponibles.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ventasObtenidas, HttpStatus.OK);
    }

    //=========================== AGREGAR ===========================
    @PostMapping("/agregar")
    public ResponseEntity<Venta> crearVenta(@Valid @RequestBody Venta venta) {
        System.out.println("Creando la venta.");
        ventaService.agregar(venta);
        return new ResponseEntity<>(venta, HttpStatus.CREATED);
    }

    //=========================== ACTUALIZAR ===========================
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable("id") int id, @Valid @RequestBody Venta venta) {
        System.out.println("Actualizando la venta con id: " + id);

        Optional<Venta> ventaActual = ventaService.obtenerPorId(id);

        if (!ventaActual.isPresent()) {
            System.out.println("Venta con id:" + id + ", no encontrada.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Venta actualVenta = ventaActual.get();
        actualVenta.setFecha(venta.getFecha());
        actualVenta.setPrecioTotal(venta.getPrecioTotal());
        actualVenta.setQr(venta.getQr());
        actualVenta.setUsuario(venta.getUsuario());
        actualVenta.setMenues(venta.getMenues());
        actualVenta.setComidas(venta.getComidas());

        ventaService.actualizar(actualVenta);
        return new ResponseEntity<>(actualVenta, HttpStatus.OK);
    }

    //=========================== ELIMINAR ===========================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable("id") int id) {
        System.out.println("Obteniendo y eliminando la venta con id: " + id);

        Optional<Venta> ventaObtenida = ventaService.obtenerPorId(id);

        if (!ventaObtenida.isPresent()) {
            System.out.println("No es posible eliminar. Venta con id: " + id + ", no encontrada.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ventaService.eliminar(ventaObtenida.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //=========================== ELIMINAR TODAS ===========================
    @DeleteMapping
    public ResponseEntity<Void> eliminarTodas() {
        System.out.println("Eliminando todas las ventas.");
        ventaService.eliminarTodo();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
