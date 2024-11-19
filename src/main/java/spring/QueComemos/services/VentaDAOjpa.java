package spring.QueComemos.services;


import org.springframework.stereotype.Repository;

import spring.QueComemos.dao.DaoGenerico;

import spring.QueComemos.model.Venta;

@Repository
public class VentaDAOjpa extends GenericDaoImpJpa<Venta> implements DaoGenerico<Venta> {
	
	public VentaDAOjpa() {
		super(Venta.class);
	}
	
	
}