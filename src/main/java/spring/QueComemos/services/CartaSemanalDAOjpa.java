package spring.QueComemos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.CartaSemanal;
import spring.QueComemos.model.Comida;


@Repository
public class CartaSemanalDAOjpa extends GenericDaoImpJpa<CartaSemanal> implements DaoGenerico<CartaSemanal> {

   public CartaSemanalDAOjpa () {
	   super(CartaSemanal.class);
   }
}
