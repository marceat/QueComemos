package spring.QueComemos.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public interface DaoGenerico<T> {
	Optional<T> obtenerPorId(int id);
	boolean actualizar(T entity);
	boolean agregar(T entity);
	boolean eliminar(T entity);
	List<T> listar();
	T persistir(T entity);
	
}
