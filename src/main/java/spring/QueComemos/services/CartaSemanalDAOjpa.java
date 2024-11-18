package spring.QueComemos.services;

import org.springframework.transaction.annotation.Transactional;
import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.CartaSemanal;


@Transactional
public class CartaSemanalDAOjpa extends GenericDaoImpJpa<CartaSemanal> implements DaoGenerico<CartaSemanal> {

	public CartaSemanalDAOjpa() {
		super(CartaSemanal.class);
	}
	
	
	
	
	
}
