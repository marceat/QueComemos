package spring.QueComemos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="usuario_general")
public class UsuarioGeneral {

    @Id
    private int dni;

    @NotNull(message = "El campo no puede estar vacío.")
    @NotBlank(message = "Falta el campo.")
    private String nombre;

    @NotNull(message = "El campo no puede estar vacío.")
    @NotBlank(message = "Falta el campo.")
    private String apellido;

    @NotNull(message = "El campo no puede estar vacío.")
    @NotBlank(message = "Falta el campo.")
    private String email;

    @NotNull(message = "El campo no puede estar vacío.")
    @NotBlank(message = "Falta el campo.")
    private String contraseña;

    @NotNull(message = "El campo no puede estar vacío.")
    @NotBlank(message = "Falta el campo.")
    private String preferenciasAlimentarias;

    @NotNull(message = "El campo no puede estar vacío.")
    @NotBlank(message = "Falta el campo.")
    private String rol;

    @NotNull(message = "El campo no puede estar vacío.")
    @NotBlank(message = "Falta el campo.")
    private String fotoPerfil;

    // Constructor vacío
    public UsuarioGeneral() {}

    // Constructor con parámetros
    public UsuarioGeneral(int dni, String nombre, String apellido, String email, String contraseña,
                          String preferenciasAlimentarias, String rol, String fotoPerfil) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.preferenciasAlimentarias = preferenciasAlimentarias;
        this.rol = rol;
        this.fotoPerfil = fotoPerfil;
    }

    // Getters y Setters
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

    public void setPreferenciasAlimentarias(String preferenciasAlimentarias) {
        this.preferenciasAlimentarias = preferenciasAlimentarias;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
