package spring.QueComemos.services;

import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.UsuarioGeneral;

public class UsuarioGeneralDAOjpa extends GenericDaoImpJpa<UsuarioGeneral> implements DaoGenerico<UsuarioGeneral> {
	
	public UsuarioGeneralDAOjpa() {
		super(UsuarioGeneral.class);
	}
	
	
}