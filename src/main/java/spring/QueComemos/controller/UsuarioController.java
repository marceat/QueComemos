package spring.QueComemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.QueComemos.model.UsuarioGeneral;
import spring.QueComemos.services.UsuarioGeneralDAOjpa;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/usuario", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UsuarioController {

    @Autowired
    UsuarioGeneralDAOjpa usuarioService;

    //================================ OBTENER  =====================================

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioGeneral> obtenerUsuarioPorId(@PathVariable("id") int id) {
        Optional<UsuarioGeneral> usuarioObtenido = usuarioService.obtenerPorId(id);

        if (!usuarioObtenido.isPresent()) {
            System.out.println("Usuario con id " + id + " no encontrado.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarioObtenido.get(), HttpStatus.OK);
    }

    //================================ LISTAR  =====================================

    @GetMapping
    public ResponseEntity<List<UsuarioGeneral>> listarUsuarios() {
        List<UsuarioGeneral> usuariosObtenidos = usuarioService.listar();

        if (usuariosObtenidos.isEmpty()) {
            System.out.println("No se encontraron usuarios disponibles.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usuariosObtenidos, HttpStatus.OK);
    }

    //================================ AGREGAR  =====================================

    @PostMapping("/agregar")
    public ResponseEntity<UsuarioGeneral> crearUsuario(@RequestBody UsuarioGeneral usuario) {
        System.out.println("Creando el usuario: " + usuario.getNombre());

        if (usuarioService.existe(usuario.getDni())) {
            System.out.println("Ya existe en la base de datos el usuario id:" + usuario.getDni() + " - " + usuario.getNombre());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        usuarioService.agregar(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //================================ ACTUALIZAR  =====================================
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioGeneral> actualizarUsuario(@PathVariable("id") int id, @RequestBody UsuarioGeneral unUsuario) {
        System.out.println("Actualizando el usuario con id: " + unUsuario.getDni());

        Optional<UsuarioGeneral> usuarioActual = usuarioService.obtenerPorId(id);

        if (!usuarioActual.isPresent()) {
            System.out.println("Usuario con id:" + id + ", no encontrado.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UsuarioGeneral usuario = usuarioActual.get();
        usuario.setNombre(unUsuario.getNombre());
        usuario.setEmail(unUsuario.getEmail());

        usuarioService.actualizar(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //================================ ELIMINAR   =====================================
    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioGeneral> eliminarUsuario(@PathVariable("id") int id) {
        System.out.println("Obteniendo y eliminando el usuario con id: " + id);

        Optional<UsuarioGeneral> usuarioObtenido = usuarioService.obtenerPorId(id);

        if (!usuarioObtenido.isPresent()) {
            System.out.println("No es posible eliminar. Usuario con id:" + id + ", no encontrado.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        usuarioService.eliminar(usuarioObtenido.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //================================ ELIMINAR TODOS  =====================================
    @DeleteMapping
    public ResponseEntity<UsuarioGeneral> eliminarTodos() {
        System.out.println("Eliminando todos los usuarios.");

        usuarioService.eliminarTodo();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

