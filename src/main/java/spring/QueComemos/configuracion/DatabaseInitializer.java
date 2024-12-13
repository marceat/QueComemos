package spring.QueComemos.configuracion;
import jakarta.transaction.Transactional;
import spring.QueComemos.model.Comida;
import spring.QueComemos.model.Menu;
import spring.QueComemos.model.Sugerencia;
import spring.QueComemos.model.UsuarioGeneral;
import spring.QueComemos.services.ComidaDAOjpa;
import spring.QueComemos.services.MenuDAOjpa;
import spring.QueComemos.services.SugerenciaDAOjpa;
import spring.QueComemos.services.UsuarioGeneralDAOjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableTransactionManagement
public class DatabaseInitializer {
	
	@Autowired
	private UsuarioGeneralDAOjpa funcionesUsuario;
	
	@Autowired
	private SugerenciaDAOjpa funcionesSugerencia;
	
	@Autowired
	private ComidaDAOjpa funcionesComida;
	
	@Autowired
	private MenuDAOjpa funcionesMenu;
	
	


    @Bean
    public CommandLineRunner demo() {
    	return (args) -> {
    		
    		//===================================== CREAMOS USUARIOS ========================================
    		UsuarioGeneral usuario1=new UsuarioGeneral(46543123,"Luz","Martinez","Luz123@gmail.com","123456","Vegano","Usuario","sin_foto");
    		UsuarioGeneral usuario2=new UsuarioGeneral(30399203,"Brenda","Poch","brenda123@gmail.com","232323","Sin restricciones","Usuario","sin_foto");
    		
    		funcionesUsuario.agregar(usuario1);
    		funcionesUsuario.agregar(usuario2);
    		
    		//===================================== CREAMOS SUGERENCIAS =====================================
    		Sugerencia sugerencia1= new Sugerencia("tardan mucho en los pedidos","atencion",usuario1);
    		Sugerencia sugerencia2= new Sugerencia("podrian agregar mas mesas al buffet","infraestructura",usuario2);
    		
    		funcionesSugerencia.agregar(sugerencia1);
    		funcionesSugerencia.agregar(sugerencia2);
    		
    		//===================================== CREAMOS MENUS =====================================
    		Menu menu1 = new Menu("Menú 1","papas fritas", "Hamburguesa con queso", "Banana", "Gaseosa", "NO VEGETARIANO", 3500, "https://th.bing.com/th/id/R.58772c589de703e801fa6f5d20139d8f?rik=XSCvP8hPprJ9PQ&pid=ImgRaw&r=0");
    		Menu menu2 = new Menu("Menú 2","papas fritas", "Pancho", "Naranja", "Gaseosa", "NO VEGETARIANO", 3500, "https://th.bing.com/th/id/R.dd87782966f36c54968f9bfc1f54493a?rik=imVXXrXvgjlzeQ&pid=ImgRaw&r=0");
    		Menu menu3 = new Menu("Menú 3","Wrap de vegetales", "Tarta de espinaca", "Manzana", "Gaseosa", "VEGETARIANO", 3500, "https://deliciouslittlebites.com/wp-content/uploads/2017/12/Greek-Veggie-Wrap-Recipe-Image-1-3.jpg");
    		Menu menu4 = new Menu("Menú 4","batatas fritas", "Tortilla española", "Pera", "Agua", "VEGETARIANO", 3500, "https://th.bing.com/th/id/OIP.H8cs0Kb-PvtvoiBheIzVgwHaG9?rs=1&pid=ImgDetMain");
    		
    		funcionesMenu.agregar(menu1);
    		funcionesMenu.agregar(menu2);
    		funcionesMenu.agregar(menu3);
    		funcionesMenu.agregar(menu4);
    		
    		//===================================== CREAMOS COMIDAS =====================================
    		Comida nuevaComida1 = new Comida("EMPANADA DE CARNE", 1500, 5);
    		Comida nuevaComida2 = new Comida("EMPANADA DE POLLO", 1500, 5);
    		Comida nuevaComida3 = new Comida("EMPANADA DE ESPINACA", 1500, 5);
    		Comida nuevaComida4 = new Comida("EMPANADA DE HUMITA", 1200, 5);
    		
    		funcionesComida.agregar(nuevaComida1);
    		funcionesComida.agregar(nuevaComida2);
    		funcionesComida.agregar(nuevaComida3);
    		funcionesComida.agregar(nuevaComida4);
    	};
    }
}
