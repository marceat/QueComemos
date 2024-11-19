package spring.QueComemos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.CartaSemanal;
import spring.QueComemos.model.Menu;
import spring.QueComemos.services.CartaSemanalDAOjpa;
import spring.QueComemos.services.MenuDAOjpa;

@ComponentScan(basePackages = "spring")
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

class TestCartaSemanal {
	
	@Autowired
	private CartaSemanalDAOjpa funcionesCartaSemanal;
	
	@Autowired
	private MenuDAOjpa funcionesMenu;
	
	CartaSemanal cartaSemanal;
	
	Menu menuLunes1;
	Menu menuLunes2;
	
	Menu menuMartes1;
	Menu menuMartes2;
	
	Menu menuMiercoles1;
	Menu menuMiercoles2;
	
	Menu menuJueves1;
	Menu menuJueves2;
	
	Menu menuViernes1;
	Menu menuViernes2;
	
	@BeforeEach
	void setUp() {
		menuLunes1 = new Menu("Menú 1","papas fritas", "Hamburguesa de carne", "Banana", "Gaseosa", "NO VEGETARIANO", 3500);
		menuLunes2 = new Menu("Menú 2","papas fritas", "Hamburguesa de soja", "Banana", "Gaseosa", "VEGETARIANO", 3500);
		
		menuMartes1 = new Menu("Menú 1","Empanada de pollo", "Porcion de pizza", "Naranja", "Gaseosa", "NO VEGETARIANO", 3500);
		menuMartes2 = new Menu("Menú 2","Empanada de verduras", "Pancho", "Naranja", "Gaseosa", "VEGETARIANO", 3500);
		
		menuMiercoles1 = new Menu("Menú 1","Wrap de pollo", "Tarta de JyQ", "Manzana", "Gaseosa", "NO VEGETARIANO", 3500);
		menuMiercoles2 = new Menu("Menú 2","Wrap de verduras", "Tarta de espinaca", "Manzana", "Gaseosa", "VEGETARIANO", 3500);
		
		menuJueves1 = new Menu("Menú 1","Empanada de carne", "Risoto con pollo", "Manzana", "Gaseosa", "NO VEGETARIANO", 3500);
		menuJueves2 = new Menu("Menú 2","Empanada de JyQ", "Fideos con bolognesa", "Manzana", "Gaseosa", "VEGETARIANO", 3500);
		
		menuViernes1 = new Menu("Menú 4","batatas fritas", "Pastel de carne", "Pera", "Agua", "NO VEGETARIANO", 3500);
		menuViernes2 = new Menu("Menú 4","batatas fritas", "Tortilla española", "Pera", "Agua", "VEGETARIANO", 3500);
		
		funcionesMenu.agregar(menuLunes1);
		funcionesMenu.agregar(menuLunes2);
		funcionesMenu.agregar(menuMartes1);
		funcionesMenu.agregar(menuMartes2);
		funcionesMenu.agregar(menuMiercoles1);
		funcionesMenu.agregar(menuMiercoles2);
		funcionesMenu.agregar(menuJueves1);
		funcionesMenu.agregar(menuJueves2);
		funcionesMenu.agregar(menuViernes1);
		funcionesMenu.agregar(menuViernes2);
		
	
		
		cartaSemanal = new CartaSemanal (menuLunes1.getId(),menuLunes2.getId(),menuMartes1.getId(),
				menuMartes2.getId(),menuMiercoles1.getId(),menuMiercoles2.getId(),menuJueves1.getId(),menuJueves2.getId(),
				menuViernes1.getId(),menuViernes2.getId());

	}

	@Test
	void agregarUnaCartaSemanal() {
		Assertions.assertEquals(true, funcionesCartaSemanal.agregar(cartaSemanal));	
		System.out.println("Se ha agregado la carta con id: "+cartaSemanal.getId());
	}
	
	@Test
	void recuperarUnaCartaSemanal() {
		funcionesCartaSemanal.agregar(cartaSemanal);
		Assertions.assertEquals(cartaSemanal.getId(), (funcionesCartaSemanal.obtenerPorId(cartaSemanal.getId()).get().getId()));
	}
	
	@Test
	void actualizarUnaCartaSemanal() {
		funcionesCartaSemanal.agregar(cartaSemanal);
		cartaSemanal.setId_menu_jueves_1(cartaSemanal.getId_menu_viernes_2());
		Assertions.assertEquals(true, funcionesCartaSemanal.actualizar(cartaSemanal));
	}
	
	@Test
	void eliminarUnaCartaSemanal() {
		funcionesCartaSemanal.agregar(cartaSemanal);
		Assertions.assertEquals(true, funcionesCartaSemanal.eliminar(cartaSemanal));
	}

}
