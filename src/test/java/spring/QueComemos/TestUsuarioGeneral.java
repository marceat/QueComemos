package spring.QueComemos;

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
	
	
	UsuarioGeneral usuario1;
	UsuarioGeneral usuario2, usuario3;
	
	
	
	@BeforeEach
	void setUp() {
		usuario1= new UsuarioGeneral(3122323,"Leonardo","Marin","LeoMar@gmail.com","21234"," "," ");
		usuario2=new UsuarioGeneral(46543123,"Luz","Martinez","Luz123@gmail.com","12345","","");
		usuario3=new UsuarioGeneral(46543123,"Brenda","Poch","brenda123@gmail.com","12345","","");
	
	}
		@Test
		void crearUsuario() {
			Assertions.assertEquals(true, funcionesUsuario.agregar(usuario1));
		}

		@Test
		void actualizarUsuario() {
			funcionesUsuario.agregar(usuario2);
			usuario2.setNombre("Lucrecia");
			
			Assertions.assertEquals(true, funcionesUsuario.actualizar(usuario2));
		}
		
		@Test
		void eliminarUsuario() {
			funcionesUsuario.agregar(usuario3);
			Assertions.assertEquals(true, funcionesUsuario.eliminar(usuario3));
		}
		
	
	
	
	
}
