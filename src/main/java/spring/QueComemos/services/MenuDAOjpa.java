package spring.QueComemos.services;

import org.springframework.transaction.annotation.Transactional;
import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.Menu;


@Transactional
public class MenuDAOjpa extends GenericDaoImpJpa<Menu>  implements DaoGenerico<Menu> {
	
	
	public MenuDAOjpa() {
		super(Menu.class);
	}
}