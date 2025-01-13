package spring.QueComemos.controller;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import spring.QueComemos.model.UsuarioGeneral;
import spring.QueComemos.services.UsuarioGeneralDAOjpa;
import org.springframework.http.MediaType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/usuario_general", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UsuarioController {

    @Autowired
    UsuarioGeneralDAOjpa usuarioService;

    //================================ OBTENER =====================================

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioGeneral> obtenerUsuarioPorId(@PathVariable("id") int id) {
        Optional<UsuarioGeneral> usuarioObtenido = usuarioService.obtenerPorId(id);

        if (!usuarioObtenido.isPresent()) {
            System.out.println("Usuario con id " + id + " no encontrado.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarioObtenido.get(), HttpStatus.OK);
    }

    //================================ LISTAR =====================================

    @GetMapping
    public ResponseEntity<List<UsuarioGeneral>> listarUsuarios() {
        List<UsuarioGeneral> usuariosObtenidos = usuarioService.listar();

        if (usuariosObtenidos.isEmpty()) {
            System.out.println("No se encontraron usuarios disponibles.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usuariosObtenidos, HttpStatus.OK);
    }

    //================================ AGREGAR =====================================

    @PostMapping("/agregar")
    public ResponseEntity<String> crearUsuario(@Valid @RequestBody UsuarioGeneral usuario) throws IOException {
        try {
            if (usuarioService.existe(usuario.getDni())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\"Ya existe el usuario con el dni/id: " + usuario.getDni() + "\"}");
            }

            // Guardar la imagen en el directorio `resources/images`
            //String uploadsDir = "src/main/resources/images/";
            //String fotoPerfilPath = uploadsDir + usuario.getFotoPerfil();// .getOriginalFilename();
            //File dir = new File(uploadsDir);
            //if (!dir.exists()) {
            //    dir.mkdirs();
            //}
            //Path path = Paths.get(fotoPerfilPath);
            //Files.write(path, usuario.getFotoPerfil().getBytes());

          
            //usuario.setFotoPerfil(fotoPerfilPath);
            usuarioService.agregar(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\":\"Usuario agregado con éxito.\"}");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\":\"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\":\"Error interno del servidor: " + e.getMessage() + "\"}");
        }
    }

    //================================ ACTUALIZAR =====================================

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarUsuario(@Valid @PathVariable("id") int id, @RequestBody UsuarioGeneral unUsuario) {
        try {
            Optional<UsuarioGeneral> usuarioActual = usuarioService.obtenerPorId(id);

            if (!usuarioActual.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra un usuario con el DNI ingresado.");
            }

            UsuarioGeneral usuario = usuarioActual.get();
            usuario.setNombre(unUsuario.getNombre());
            usuario.setApellido(unUsuario.getApellido());
            usuario.setEmail(unUsuario.getEmail());
            usuario.setContraseña(unUsuario.getContraseña());
            usuario.setPreferenciasAlimentarias(unUsuario.getPreferenciasAlimentarias());
            usuario.setRol(unUsuario.getRol());
            usuario.setFotoPerfil(unUsuario.getFotoPerfil());

            usuarioService.actualizar(usuario);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario actualizado con éxito.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor: " + e.getMessage());
        }
    }

    //================================ ELIMINAR =====================================

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

    //================================ ELIMINAR TODOS =====================================

    @DeleteMapping
    public ResponseEntity<UsuarioGeneral> eliminarTodos() {
        System.out.println("Eliminando todos los usuarios.");

        usuarioService.eliminarTodo();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
