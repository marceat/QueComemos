package spring.QueComemos.services;

import org.springframework.stereotype.Repository;

import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.UsuarioGeneral;

@Repository
public class UsuarioGeneralDAOjpa extends GenericDaoImpJpa<UsuarioGeneral> implements DaoGenerico<UsuarioGeneral> {
	
	public UsuarioGeneralDAOjpa() {
		super(UsuarioGeneral.class);
	}
	
	
}