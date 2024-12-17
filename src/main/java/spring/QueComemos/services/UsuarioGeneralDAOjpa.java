package spring.QueComemos.services;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.QueComemos.dao.UsuarioGeneralDAO;
import spring.QueComemos.model.UsuarioGeneral;

@Service
public class UsuarioGeneralDAOjpa {

    @Autowired
    private UsuarioGeneralDAO usuarioGeneralDAO;

    public Optional<UsuarioGeneral> obtenerPorId(int id) {
        return usuarioGeneralDAO.findById(id);
    }

    public Optional<UsuarioGeneral> obtenerPorDni(int dni) {
        return usuarioGeneralDAO.findByDni(dni);
    }
    public Optional<UsuarioGeneral> obtenerPorEmail(String email) { 
    	return usuarioGeneralDAO.findByEmail(email); 
   }
    public List<UsuarioGeneral> listar() {
        return usuarioGeneralDAO.findAll();
    }

    public UsuarioGeneral agregar(UsuarioGeneral usuario) {
        return usuarioGeneralDAO.save(usuario);
    }

    public UsuarioGeneral actualizar(UsuarioGeneral usuario) {
        return usuarioGeneralDAO.save(usuario);
    }

    public void eliminar(UsuarioGeneral usuario) {
        usuarioGeneralDAO.delete(usuario);
    }

    public void eliminarTodo() {
        usuarioGeneralDAO.deleteAll();
    }

    public boolean existe(int dni) {
        return usuarioGeneralDAO.findByDni(dni).isPresent();
    }
}

