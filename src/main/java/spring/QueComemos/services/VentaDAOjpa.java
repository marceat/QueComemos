package spring.QueComemos.services;


import spring.QueComemos.dao.DaoGenerico;

import spring.QueComemos.model.Venta;

public class VentaDAOjpa extends GenericDaoImpJpa<Venta> implements DaoGenerico<Venta> {
	
	public VentaDAOjpa() {
		super(Venta.class);
	}
	
	
}