package spring.QueComemos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.Comida;
import spring.QueComemos.model.Menu;

@Transactional
public class MenuDAOjpa implements DaoGenerico<Menu> {
	
	@PersistenceContext
	 private EntityManager entityManager;
	
	 public void setEntityManager(EntityManager em){
		 this.entityManager = em;
	 }
	 
	 public EntityManager getEntityManager() {
		 return entityManager;
	 }

	@Override
	public Menu obtenerPorId(int id) {
			
		Menu menuObtenido = null;
		
		try {
			/* menuObtenido = em.find(Menu.class, id); */
			menuObtenido = this.getEntityManager().find(Menu.class, id);
			
		} catch (Exception e) {
            e.printStackTrace();
        }
		
		return menuObtenido;
	}

	@Override
	public boolean actualizar(Menu unMenu) {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		//EntityManager em = emf.createEntityManager();
		//EntityTransaction etx = em.getTransaction();
		boolean actualizado=false;

		try {		
			//etx.begin();
			//em.merge(unMenu);
			this.getEntityManager().merge(unMenu);
			//etx.commit();
			actualizado = true;
			
		} catch (Exception e) {
            e.printStackTrace();
            actualizado = false;
        }
		
		return actualizado;
	}

	@Override
	public boolean agregar(Menu unMenu) {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		//EntityManager em = emf.createEntityManager();
		//EntityTransaction etx = em.getTransaction();
		boolean actualizado=false;
		
		try {
			this.getEntityManager().merge(unMenu);
			//etx.begin();
			//em.persist(unMenu);
			//em.merge(unMenu);
			//etx.commit();
			actualizado=true;
			
		} catch (Exception e) {
            e.printStackTrace();
            actualizado=false;
        } 
		return actualizado;
	}

	@Override
	public boolean eliminar(Menu unMenu) {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		//EntityManager em = emf.createEntityManager();
		//EntityTransaction etx = em.getTransaction();
		boolean eliminado=false;
		
		try {
			//etx.begin();
			unMenu = this.getEntityManager().merge(unMenu);
			//em.remove(unMenu);
			//etx.commit();
			eliminado=true;
			
		} catch (Exception e) {
            e.printStackTrace();
            eliminado=false;
        } 
		return eliminado;
	}

	@Override
	public List<Menu> listar() {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		//EntityManager em = emf.createEntityManager();
		//EntityTransaction etx = em.getTransaction();
		List<Menu> listaDeMenues = null;
		
		try {
			this.getEntityManager().createQuery("SELECT m FROM Menu m", Menu.class);
			//Query query = em.createQuery("SELECT m FROM Menu m", Menu.class);
			Query query = this.getEntityManager().createQuery("SELECT m FROM Menu m", Menu.class);
			listaDeMenues = query.getResultList();

		} catch (Exception e) {
            e.printStackTrace(); 
        } 
		return listaDeMenues;
	}

}
