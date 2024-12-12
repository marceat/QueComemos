package spring.QueComemos.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="SUGERENCIA")
public class Sugerencia {
    
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="usuario_dni")
    @NotNull(message = "El usuario no puede ser nulo")
    private UsuarioGeneral usuario;

    @NotBlank(message = "El tipo de sugerencia no puede estar vacío")
    private String tipoDeSugerencia;

    @NotBlank(message = "El mensaje no puede estar vacío")
    @Size(max = 500, message = "El mensaje no puede tener más de 500 caracteres")
    private String mensaje;

    public Sugerencia(String unMensaje, String unTipo, UsuarioGeneral usuario) {
        this.mensaje = unMensaje;
        this.tipoDeSugerencia = unTipo;
        this.usuario = usuario;
    }

    public Sugerencia() {}

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioGeneral getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioGeneral usuario) {
        this.usuario = usuario;
    }

    public String getTipoDeSugerencia() {
        return tipoDeSugerencia;
    }

    public void setTipoDeSugerencia(String tipoDeSugerencia) {
        this.tipoDeSugerencia = tipoDeSugerencia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

