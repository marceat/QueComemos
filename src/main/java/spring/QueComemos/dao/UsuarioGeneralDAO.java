package spring.QueComemos.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.QueComemos.model.UsuarioGeneral;

@Repository
public interface UsuarioGeneralDAO extends JpaRepository<UsuarioGeneral, Integer> {
    Optional<UsuarioGeneral> findByDni(int dni);
    Optional<UsuarioGeneral> findByEmail(String email); 
}
