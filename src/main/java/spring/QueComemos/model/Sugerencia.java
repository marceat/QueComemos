package spring.QueComemos.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="SUGERENCIA")
public class Sugerencia {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="usuario_dni")
	UsuarioGeneral usuario;
	
	String tipoDeSugerencia;
	String mensaje;
    
	
	public Sugerencia(String unMensaje,String unTipo,UsuarioGeneral usuario) {
		this.mensaje=unMensaje;
		this.tipoDeSugerencia=unTipo;
		this.usuario=usuario;
		
		
	}
	public Sugerencia() {}
	
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
