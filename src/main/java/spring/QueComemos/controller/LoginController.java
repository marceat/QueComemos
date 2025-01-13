package spring.QueComemos.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import spring.QueComemos.util.JwtTokenUtil;
import spring.QueComemos.model.LoginRequest;
import spring.QueComemos.model.UsuarioGeneral;
import spring.QueComemos.services.UsuarioGeneralDAOjpa;
import spring.QueComemos.model.JwtResponse;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    //@Autowired
    //private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioGeneralDAOjpa usuarioService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioGeneral credentials) {
        Optional<UsuarioGeneral> usuario = usuarioService.obtenerPorDni(credentials.getDni());
        
        System.out.println("Comparando: "+credentials.getDni());
        if (!usuario.isPresent() || !usuario.get().getContraseña().equals(credentials.getContraseña())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\":\"Usuario o contraseña incorrectos\"}");
        }

        return ResponseEntity.ok("{\"message\":\"Inicio de sesión exitoso\"}");

    }
}
