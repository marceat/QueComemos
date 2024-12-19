package spring.QueComemos.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.QueComemos.model.UsuarioGeneral;
import spring.QueComemos.dao.UsuarioGeneralDAO;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioGeneralDAO usuarioGeneralDAO;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioGeneral usuario = usuarioGeneralDAO.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));
        
        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getEmail())
                .password(usuario.getContraseña())
                .authorities("USER") // Asigna los roles o autoridades necesarios
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
