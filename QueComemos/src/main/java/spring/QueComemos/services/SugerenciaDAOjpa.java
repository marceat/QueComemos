package spring.QueComemos.services;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.CartaSemanal;
import spring.QueComemos.model.Sugerencia;
import spring.QueComemos.model.Venta;

public class SugerenciaDAOjpa implements DaoGenerico<Sugerencia> {
	
	@Override
	public Sugerencia obtenerPorId(int id) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
	    EntityManager em = emf.createEntityManager();
	    Sugerencia sugerencia = null;

	    try {
	    	sugerencia= em.find(Sugerencia.class, id);
	    } catch (Exception e) {
	        e.printStackTrace(); //Maneja la excepción adecuadamente en un entorno real
	    } finally {
	        em.close();
	    }
	    
	    return sugerencia;
	}

	
	public boolean agregar(Sugerencia unaSugerencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		boolean agregado=false;
		try {
			etx.begin();
			em.persist(unaSugerencia);
			em.merge(unaSugerencia);
			etx.commit();
			agregado=true;
			
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
		return agregado;
	}
	
	public boolean actualizar(Sugerencia unaSugerencia) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction etx = em.getTransaction();
	    boolean actualizado = false;

	    try {
	        etx.begin();
	      
	        em.merge(unaSugerencia);
	        etx.commit();
	        actualizado = true;
	    } catch (Exception e) {
	        if (etx.isActive()) {
	            etx.rollback();
	        }
	        e.printStackTrace(); // Maneja la excepción adecuadamente en un entorno real
	    } finally {
	        em.close();
	    }

	    return actualizado;
	}

	public boolean eliminar(Sugerencia unaSugerencia) {
		   EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		   EntityManager em = emf.createEntityManager();
		   EntityTransaction etx = em.getTransaction();
		   boolean eliminado = false;

		    try {
		        etx.begin();
		        unaSugerencia = em.merge(unaSugerencia);  //ACTUALIZA SI SE HACE UNA SUGERENCIA Y NO SE GUARDÓ
		        em.remove(unaSugerencia);
		        etx.commit();
		        eliminado = true;
		    } catch (Exception e) {
		        if (etx.isActive()) {
		            etx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        em.close();
		    }

		    return eliminado;
		}


	public List<Sugerencia> listar() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
	    EntityManager em = emf.createEntityManager();
	    List<Sugerencia> sugerencias = null;

	    try {
	        TypedQuery<Sugerencia> query = em.createQuery("SELECT s FROM Sugerencia s ", Sugerencia.class);
	        sugerencias = query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace(); // Maneja la excepción adecuadamente en un entorno real
	    } finally {
	        em.close();
	    }
	    
	    return sugerencias;
	}

}
