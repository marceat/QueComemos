package spring.QueComemos;

import java.sql.Date;
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
import spring.QueComemos.model.Venta;
import spring.QueComemos.services.VentaDAOjpa;

@ComponentScan(basePackages = "spring")
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class TestVenta {
	@Autowired
	private VentaDAOjpa funcionesVentas;
	
	
	Venta venta1;
	Venta venta2;
	Venta venta3;
	UsuarioGeneral usuario;
	
	@BeforeEach
	void setUp() {
		usuario= new UsuarioGeneral(23435543,"Dario","Bazi","Dario123@gmail.com","12345"," "," ");
		
		venta1= new Venta(new Date(23/05/2024),5021.33," ",usuario,null,null);
		venta2= new Venta(new Date(13/12/2023),6021.33," ",usuario,null,null);
		
		venta3= new Venta(new Date(05/06/2018),1021.33," ",usuario,null,null);
	}

	@Test
	void agregarVenta() {
		Assertions.assertEquals(true, funcionesVentas.agregar(venta1));
	}
	
	@Test
	void actualizarVenta() {
		funcionesVentas.agregar(venta2);
		venta2.setPrecioTotal(2132.22);
		Assertions.assertEquals(true, funcionesVentas.actualizar(venta2));
		
	}

	@Test
	void eliminarVenta() {
		funcionesVentas.agregar(venta3);
		Assertions.assertEquals(true, funcionesVentas.eliminar(venta3));
	}
}
	

	
	
