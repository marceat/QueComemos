package spring.QueComemos.dao;
import java.util.List;

import spring.QueComemos.model.UsuarioGeneral;

public interface UsuarioGeneralDAO extends DaoGenerico<UsuarioGeneral> {
	
	
	boolean iniciarSesion(String dni, int contraseña) ;
	boolean cerrarSesion() ;
	
	List<UsuarioGeneral> listarUsuariosComunes() ;
	List<UsuarioGeneral> listarUsuariosResponsablesDeTurno();
	
}
