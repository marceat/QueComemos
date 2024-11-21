package spring.QueComemos.services;


import java.util.Optional;

import org.springframework.stereotype.Repository;
import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.Comida;

@Repository
public class ComidaDAOjpa extends GenericDaoImpJpa<Comida> implements DaoGenerico<Comida> {
	
	public ComidaDAOjpa() {
		super(Comida.class);
	}
	
}
