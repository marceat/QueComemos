package spring.QueComemos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.CartaSemanal;
import spring.QueComemos.model.Comida;
import spring.QueComemos.model.Menu;

@Repository
public class MenuDAOjpa extends GenericDaoImpJpa<Menu> implements DaoGenerico<Menu> {

	public MenuDAOjpa() {
		super(Menu.class);
	}
}
