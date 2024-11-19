package spring.QueComemos;

import static org.junit.jupiter.api.Assertions.*;

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
import spring.QueComemos.model.Menu;
import spring.QueComemos.services.MenuDAOjpa;

@ComponentScan(basePackages = "spring")
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestMenu {
	
	@Autowired
	private MenuDAOjpa funcionesMenu;
	
	Menu menu1;
	Menu menu2;
	Menu menu3;
	Menu menu4;
	
	@BeforeEach
	void setUp() {
		menu1 = new Menu("Menú 1","papas fritas", "Hamburguesa con queso", "Banana", "Gaseosa", "NO VEGETARIANO", 3500);
		menu2 = new Menu("Menú 2","papas fritas", "Pancho", "Naranja", "Gaseosa", "NO VEGETARIANO", 3500);
		menu3 = new Menu("Menú 3","Wrap de vegetales", "Tarta de espinaca", "Manzana", "Gaseosa", "VEGETARIANO", 3500);
		menu4 = new Menu("Menú 4","batatas fritas", "Tortilla española", "Pera", "Agua", "VEGETARIANO", 3500);
		
	}

	@Test
	void agregarUnMenu() {
		Assertions.assertEquals(true, funcionesMenu.agregar(menu1));
		
	}
	
	@Test
	void obtenerUnMenu() {
		funcionesMenu.agregar(menu2);
		//System.out.println("Comparando id "+nuevaComida2.getId()+" CON "+funcionesComida.obtenerComidaPorId(nuevaComida2.getId()).getId());
		Assertions.assertEquals(menu2.getId(), (funcionesMenu.obtenerPorId(menu2.getId())).get().getId());
	}
	
	@Test
	void actualizarUnMenu() {
		funcionesMenu.agregar(menu3);
		menu3.setEntrada("NUGGETS DE ACELGA");
		menu3.setNombreMenu("Menu 3 modificado");
		menu3.setPlatoPrincipal("TARTA DE BERENJENA");
		Assertions.assertEquals(true, funcionesMenu.actualizar(menu3));
	}
	
	@Test
	void eliminarUnMenu() {
		funcionesMenu.agregar(menu3);
		Assertions.assertEquals(true, funcionesMenu.eliminar(menu4));
	}
}
