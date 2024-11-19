package spring.QueComemos.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.CartaSemanal;


@Repository
public class CartaSemanalDAOjpa extends GenericDaoImpJpa<CartaSemanal> implements DaoGenerico<CartaSemanal> {

   public CartaSemanalDAOjpa () {
	   super(CartaSemanal.class);
   }
	
}
