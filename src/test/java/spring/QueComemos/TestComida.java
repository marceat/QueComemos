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
import spring.QueComemos.model.Comida;
import spring.QueComemos.services.ComidaDAOjpa;

@ComponentScan(basePackages = "spring")
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

class TestComida {
	
	@Autowired
	private ComidaDAOjpa funcionesComida;
	
	Comida nuevaComida1;
	Comida nuevaComida2;
	Comida nuevaComida3;
	Comida nuevaComida4;
	
	@BeforeEach
	void setUp() {
		
		// Create a new AnnotationConfigApplicationContext
		 //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("spring.QueComemos");
		 // Registra la clase de configuration (PersistenceConfig)
		 //ctx.register(PersistenceConfiguracion.class);
		 // Refresca para actualizar la creacion de beans 
		 //ctx.refresh();
		 
		//funcionesComida = FactoryDAO.getComidaDAO();
        
		//funcionesComida = ctx.getBean("ComidaDAO", ComidaDAOjpa.class);
        
		nuevaComida1 = new Comida("EMPANADA DE CARNE", 1500, 5);
		nuevaComida2 = new Comida("EMPANADA DE POLLO", 1500, 5);
		nuevaComida3 = new Comida("EMPANADA DE ESPINACA", 1500, 5);
		nuevaComida4 = new Comida("EMPANADA DE HUMITA", 1200, 5);
		
		System.out.println(nuevaComida1.getId());
		System.out.println(nuevaComida2.getId());
		System.out.println(nuevaComida3.getId());
		
	}

	@Test
	void agregarUnaComida() {
		Assertions.assertEquals(true, funcionesComida.agregar(nuevaComida1));
		//System.out.println("Comparando id "+nuevaComida1.getId());
	}
	
	@Test
	void obtenerUnaComida() {
		funcionesComida.agregar(nuevaComida2);
		System.out.println(" ============ id encontrado comida 2: "+funcionesComida.obtenerPorId(nuevaComida2.getId()).get());
		//System.out.println("Comparando id "+nuevaComida2.getId()+" CON "+funcionesComida.obtenerComidaPorId(nuevaComida2.getId()).getId());
		Assertions.assertEquals(nuevaComida2.getId(), (funcionesComida.obtenerPorId(nuevaComida2.getId())).get().getId());
		
	}
	
	@Test
	void actualizarUnaComida() {
		funcionesComida.agregar(nuevaComida3);
		nuevaComida3.setNombre("TARTA DE CALABAZA Y MUZARELLA");
		Assertions.assertEquals(true, funcionesComida.actualizar(nuevaComida3));
	}
	
	@Test
	void eliminarUnaComida() {
		funcionesComida.agregar(nuevaComida4);
		Assertions.assertEquals(true, funcionesComida.eliminar(nuevaComida4));
	}

}
