package spring.QueComemos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import spring.QueComemos.dao.DaoGenerico;
import spring.QueComemos.model.Comida;

@Transactional
public class GenericDaoImpJpa<T> implements DaoGenerico<T> {
	
	@PersistenceContext
	 private EntityManager entityManager;
	
	protected Class<T> persistentClass;
	
	public void setEntityManager(EntityManager em){
		 this.entityManager = em;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public EntityManager getEntityManager() {
		 return entityManager;
	}
	
	public GenericDaoImpJpa(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	 @Override
	 public T persistir(T entity) {
		 this.getEntityManager().persist(entity);
		 return entity;
	 }

	@Override
	public Optional<T> obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.entityManager.find(persistentClass, id));
	}

	@Override
	public boolean actualizar(T entity) {
		boolean actualizado=false;
		try {
			this.entityManager.merge(entity);
			actualizado = true;
			
		} catch (Exception e) {
            e.printStackTrace();
            actualizado = false;
        }
		
		return actualizado;
	}

	@Override
	public boolean agregar(T entity) {
		boolean actualizado=false;		
		try {
			this.entityManager.persist(entity);
			actualizado=true;
			
		} catch (Exception e) {
            e.printStackTrace();
            actualizado=false;
        } 
		return actualizado;
	}

	@Override
	public boolean eliminar(T entity) {
		boolean eliminado=false;
		
		try {
			this.entityManager.remove(entity);
			eliminado=true;
			
		} catch (Exception e) {
            e.printStackTrace();
            eliminado=false;
        } 
		
		return eliminado;
	}
	
	@Override
	public boolean eliminarTodo() {
		boolean eliminado=false;
		
		try {
			this.entityManager.createQuery("DELETE FROM " + persistentClass.getSimpleName()).executeUpdate();
			eliminado=true;
			
		} catch (Exception e) {
            e.printStackTrace();
            eliminado=false;
        } 
		
		return eliminado;
	}

	@Override
	public List<T> listar() {
		return this.entityManager.createQuery("SELECT t FROM " + this.persistentClass.getSimpleName() + " t", persistentClass).getResultList();
			
	}
	
	public boolean existe(int id) {
		return obtenerPorId(id).isPresent();
	}

}
