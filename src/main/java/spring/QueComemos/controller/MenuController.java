package spring.QueComemos.controller;

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

import jakarta.validation.Valid;
import spring.QueComemos.model.Menu;
import spring.QueComemos.services.MenuDAOjpa;

@RestController
@RequestMapping(value="/api/menu", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MenuController {

    @Autowired
    private MenuDAOjpa menuService;

    //================================ OBTENER =====================================
    @GetMapping("/{id}")
    public ResponseEntity<Menu> obtenerMenuPorId(@PathVariable("id") int id) {
        Optional<Menu> menuObtenido = menuService.obtenerPorId(id);

        if (!menuObtenido.isPresent()) {
            System.out.println("Menu con id "+id+" no encontrado.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(menuObtenido.get(), HttpStatus.OK);
    }

    //================================ LISTAR =====================================
    @GetMapping
    public ResponseEntity<List<Menu>> listarMenu() {
        List<Menu> menuesObtenidos = menuService.listar();

        if (menuesObtenidos.isEmpty()) {
            System.out.println("No se encontraron menús disponibles.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(menuesObtenidos, HttpStatus.OK);
    }

    //================================ AGREGAR =====================================
    @PostMapping("/agregar")
    public ResponseEntity<Menu> crearMenu(@Valid @RequestBody Menu menu) {
        System.out.println("Creando el menú: " + menu.getNombreMenu());
        if (menuService.existe(menu.getId())) {
            System.out.println("Ya existe en la base de datos el menú con id: " + menu.getId());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        menuService.agregar(menu);
        return new ResponseEntity<>(menu, HttpStatus.CREATED);
    }

    //================================ ACTUALIZAR =====================================
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Menu> actualizarMenu(@PathVariable("id") int id, @Valid @RequestBody Menu menu) {
        System.out.println("Actualizando el menú con id: " + id);

        Optional<Menu> menuActual = menuService.obtenerPorId(id);

        if (!menuActual.isPresent()) {
            System.out.println("Menú con id: " + id + ", no encontrado.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Menu actualMenu = menuActual.get();
        actualMenu.setNombreMenu(menu.getNombreMenu());
        actualMenu.setPlatoPrincipal(menu.getPlatoPrincipal());
        actualMenu.setEntrada(menu.getEntrada());
        actualMenu.setBebida(menu.getBebida());
        actualMenu.setPostre(menu.getPostre());
        actualMenu.setPrecio(menu.getPrecio());
        actualMenu.setTipoMenu(menu.getTipoMenu());

        menuService.actualizar(actualMenu);
        return new ResponseEntity<>(actualMenu, HttpStatus.OK);
    }

    //================================ ELIMINAR =====================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMenu(@PathVariable("id") int id) {
        System.out.println("Obteniendo y eliminando el menú con id: " + id);

        Optional<Menu> menuObtenido = menuService.obtenerPorId(id);

        if (!menuObtenido.isPresent()) {
            System.out.println("No es posible eliminar. Menú con id: " + id + ", no encontrado.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        menuService.eliminar(menuObtenido.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //================================ ELIMINAR TODAS =====================================
    @DeleteMapping
    public ResponseEntity<Void> eliminarTodas() {
        System.out.println("Eliminando todos los menús.");
        menuService.eliminarTodo();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
