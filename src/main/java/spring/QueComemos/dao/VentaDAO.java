package spring.QueComemos.dao;


import spring.QueComemos.model.UsuarioGeneral;
import spring.QueComemos.model.Venta;



public interface VentaDAO extends DaoGenerico<Venta> {
	
	
	void enviarQrPorMail(UsuarioGeneral usuario); 
	

}
