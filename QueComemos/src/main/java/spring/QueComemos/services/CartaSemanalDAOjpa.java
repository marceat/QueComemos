package spring.QueComemos.services;

import java.util.ArrayList;
import java.util.List;

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


@Transactional
public class CartaSemanalDAOjpa implements DaoGenerico<CartaSemanal> {

    @Override
    public CartaSemanal obtenerPorId(int id) {
    	
    	
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
        EntityManager em = emf.createEntityManager();
        CartaSemanal cartaObtenida = null;

        try {
            cartaObtenida = em.find(CartaSemanal.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return cartaObtenida;
    }

    @Override
    public boolean actualizar(CartaSemanal entity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        boolean actualizado = false;

        try {
            etx.begin();
            em.merge(entity);
            etx.commit();
            actualizado = true;
        } catch (Exception e) {
            if (etx.isActive()) {
                etx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

        return actualizado;
    }

    @Override
    public boolean agregar(CartaSemanal entity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        boolean creado = false;

        try {
            etx.begin();
            em.persist(entity);
            etx.commit();
            creado = true;
        } catch (Exception e) {
            if (etx.isActive()) {
                etx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

        return creado;
    }

    @Override
    public boolean eliminar(CartaSemanal entity) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        boolean eliminado = false;

        try {
            etx.begin();
            entity = em.merge(entity); // Asegúrate de que la entidad está en el contexto de persistencia
            em.remove(entity);
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
    public List<CartaSemanal> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
        EntityManager em = emf.createEntityManager();
        List<CartaSemanal> cartas = null;

        try {
            TypedQuery<CartaSemanal> query = em.createQuery("SELECT c FROM CartaSemanal c", CartaSemanal.class);
            cartas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return cartas;
    }
}
