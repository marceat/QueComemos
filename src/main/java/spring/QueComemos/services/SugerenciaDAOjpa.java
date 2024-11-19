package spring.QueComemos.services;


import org.springframework.stereotype.Repository;

import spring.QueComemos.dao.DaoGenerico;

import spring.QueComemos.model.Sugerencia;

@Repository
public class SugerenciaDAOjpa extends  GenericDaoImpJpa<Sugerencia> implements DaoGenerico<Sugerencia> {
	
	public SugerenciaDAOjpa() {
		super(Sugerencia.class);
	}
	
	
}
	
	