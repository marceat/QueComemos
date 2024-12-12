package spring.QueComemos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuario_general")
public class UsuarioGeneral {

    @Id
    @NotNull(message = "El DNI no puede ser nulo")
    private int dni;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 1, max = 50, message = "El apellido debe tener entre 1 y 50 caracteres")
    private String apellido;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe ser válido")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contraseña;

    @NotBlank(message = "Las preferencias alimentarias no pueden estar vacías")
    private String preferenciasAlimentarias;

    @NotBlank(message = "El rol no puede estar vacío")
    private String rol;

    private String fotoPerfil;

    public UsuarioGeneral() {
    }

    public UsuarioGeneral(int unDni, String unNombre, String unApellido, String unEmail, String unaContraseña, String preferencia, String unRol, String foto) {
        this.dni = unDni;
        this.nombre = unNombre;
        this.apellido = unApellido;
        this.email = unEmail;
        this.contraseña = unaContraseña;
        this.preferenciasAlimentarias = preferencia;
        this.rol = unRol;
        this.fotoPerfil = foto;
    }

    // Getters y setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPreferenciasAlimentarias() {
        return preferenciasAlimentarias;
    }

    public void setPreferenciasAlimentarias(String preferencia) {
        this.preferenciasAlimentarias = preferencia;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
