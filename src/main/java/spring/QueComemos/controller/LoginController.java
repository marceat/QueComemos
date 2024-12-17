package spring.QueComemos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.QueComemos.model.UsuarioGeneral;
import spring.QueComemos.services.UsuarioGeneralDAOjpa;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class LoginController {

    @Autowired
    private UsuarioGeneralDAOjpa usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioGeneral credentials) {
        System.out.println("Intentando iniciar sesión con email: " + credentials.getEmail());
        Optional<UsuarioGeneral> usuario = usuarioService.obtenerPorEmail(credentials.getEmail());

        if (!usuario.isPresent()) {
            System.out.println("Usuario no encontrado con email: " + credentials.getEmail());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\":\"Usuario o contraseña incorrectos\"}");
        }

        if (!usuario.get().getContraseña().equals(credentials.getContraseña())) {
            System.out.println("Contraseña incorrecta para el email: " + credentials.getEmail());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\":\"Usuario o contraseña incorrectos\"}");
        }

        System.out.println("Inicio de sesión exitoso para el email: " + credentials.getEmail());
        return ResponseEntity.ok("{\"message\":\"Inicio de sesión exitoso\"}");
    }
}
