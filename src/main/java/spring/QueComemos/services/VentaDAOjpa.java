package spring.QueComemos.services;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.dao.VentaDAO;
import spring.QueComemos.model.Sugerencia;
import spring.QueComemos.model.UsuarioGeneral;
import spring.QueComemos.model.Venta;

public class VentaDAOjpa implements VentaDAO {

	@Override
	public Venta obtenerPorId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
	    EntityManager em = emf.createEntityManager();
	    Venta venta= null;

	    try {
	        venta= em.find(Venta.class, id);
	    } catch (Exception e) {
	        e.printStackTrace(); //Maneja la excepción adecuadamente en un entorno real
	    } finally {
	        em.close();
	    }
	    
	    return venta;
	}
	

	@Override
	public boolean actualizar(Venta unaVenta) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		    EntityManager em = emf.createEntityManager();
		    EntityTransaction etx = em.getTransaction();
		    boolean actualizado = false;

		    try {
		        etx.begin();
		      
		        em.merge(unaVenta);
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

	@Override
	public boolean agregar(Venta unaVenta) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		boolean agregado=false;
		try {
			etx.begin();
			em.persist(unaVenta);
			em.merge(unaVenta);
			etx.commit();
			agregado=true;
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
		return agregado;
	}
	
	@Override
	public boolean eliminar(Venta unaVenta) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		   EntityManager em = emf.createEntityManager();
		   EntityTransaction etx = em.getTransaction();
		   boolean eliminado = false;

		    try {
		        etx.begin();
		        unaVenta = em.merge(unaVenta);  //ACTUALIZA SI SE HACE UNA SUGERENCIA Y NO SE GUARDÓ
		        em.remove(unaVenta);
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

	

	@Override
	public List<Venta> listar() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
	    EntityManager em = emf.createEntityManager();
	    List<Venta> ventas = null;

	    try {
	        TypedQuery<Venta> query = em.createQuery("SELECT v FROM Venta v", Venta.class);
	        ventas = query.getResultList();
	    } catch (Exception e) {
	        e.printStackTrace(); // Maneja la excepción adecuadamente en un entorno real
	    } finally {
	        em.close();
	    }

	    return ventas;
	}


	public void enviarQrPorMail(UsuarioGeneral usuario) {
		// TODO Auto-generated method stub
		
	}
	
	
}