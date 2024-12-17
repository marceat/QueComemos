package spring.QueComemos;


import java.util.Optional; 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import spring.QueComemos.model.UsuarioGeneral;
import spring.QueComemos.services.UsuarioGeneralDAOjpa;

@ComponentScan(basePackages = "spring")
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestUsuarioGeneral {

    @Autowired
    private UsuarioGeneralDAOjpa funcionesUsuario;

    private UsuarioGeneral usuario1;
    private UsuarioGeneral usuario2;
    private UsuarioGeneral usuario3;

    @BeforeEach
    void setUp() {
        usuario1 = new UsuarioGeneral(3122323, "Leonardo", "Marin", "LeoMar@gmail.com", "21234", "Vegano", "Usuario", "sin_foto");
        usuario2 = new UsuarioGeneral(46543123, "Luz", "Martinez", "Luz123@gmail.com", "12345", "Vegetariano", "Usuario", "sin_foto");
        usuario3 = new UsuarioGeneral(46543124, "Laura", "Venitez", "Lau123@gmail.com", "202060", "Sin Restricciones", "Usuario", "sin_foto");
    }

    @Test
    void crearUsuario() {
        UsuarioGeneral savedUsuario = funcionesUsuario.agregar(usuario1);
        Assertions.assertNotNull(savedUsuario);
        Assertions.assertEquals(usuario1.getDni(), savedUsuario.getDni());
    }

    @Test
    void actualizarUsuario() {
        UsuarioGeneral savedUsuario = funcionesUsuario.agregar(usuario2);
        savedUsuario.setNombre("Lucrecia");
        UsuarioGeneral updatedUsuario = funcionesUsuario.actualizar(savedUsuario);
        Assertions.assertEquals("Lucrecia", updatedUsuario.getNombre());
    }

    @Test
    void eliminarUsuario() {
        funcionesUsuario.agregar(usuario3);
        funcionesUsuario.eliminar(usuario3);
        Optional<UsuarioGeneral> deletedUsuario = funcionesUsuario.obtenerPorId(usuario3.getDni());
        Assertions.assertTrue(deletedUsuario.isEmpty());
    }
}
