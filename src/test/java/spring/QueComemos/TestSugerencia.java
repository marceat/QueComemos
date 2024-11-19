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

import spring.QueComemos.model.Sugerencia;
import spring.QueComemos.model.UsuarioGeneral;
import spring.QueComemos.services.SugerenciaDAOjpa;

@ComponentScan(basePackages = "spring")
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class TestSugerencia {

	@Autowired
	private SugerenciaDAOjpa funcionesSugerencia;
	
	
	Sugerencia sugerencia1;
	Sugerencia sugerencia2;
	Sugerencia sugerencia3;
	UsuarioGeneral usuario;
	UsuarioGeneral usuario2;
	
	
	@BeforeEach
	void setUp() {
		
	usuario= new UsuarioGeneral(43323456,"Pedro","Rios","Pedro@gmail.com","12345"," "," ");
	sugerencia1= new Sugerencia("mala atención","atención",usuario);
	usuario2= new UsuarioGeneral(35456123,"Juana","Diaz","JuanaD@gmail.com","23234"," "," ");
	sugerencia2= new Sugerencia("tardan mucho en los pedidos","atencion",usuario);
	sugerencia3= new Sugerencia("podrian agregar mas mesas al buffet","infraestructura",usuario2);
	}
	
	@Test
	void agregarSugerencia() {
		Assertions.assertEquals(true,funcionesSugerencia.agregar(sugerencia1) );
	
	}
	
	@Test
	void actualizarSugerencia() {
		funcionesSugerencia.agregar(sugerencia2);
		sugerencia2.setMensaje("podrian organizar mas los pedidos");
		Assertions.assertEquals(true,funcionesSugerencia.actualizar(sugerencia2));
	}
	@Test
	void eliminarSugerencia() {
		funcionesSugerencia.agregar(sugerencia3);
		Assertions.assertEquals(true, funcionesSugerencia.eliminar(sugerencia3));
	}
	
	}
	

	
	
	
	
	
	
	
