package spring.QueComemos.model;
import java.io.File;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario_general")
public class UsuarioGeneral {
	
	@Id
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private String contraseña;
	private String preferenciasAlimentarias;
	private String rol;
	private String fotoPerfil;
	
	public UsuarioGeneral() {
		
	}
	public UsuarioGeneral(int unDni, String unNombre, String unApellido, String unEmail, String unaContraseña, String preferenciasAlimentarias,String unRol, String foto) {
		this.dni = unDni;
		this.nombre = unNombre;
		this.apellido = unApellido;
		this.email = unEmail;
		this.contraseña = unaContraseña;
		this.preferenciasAlimentarias = preferenciasAlimentarias;
		this.rol=unRol;
		this.fotoPerfil = foto;
		
	}
	
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
	public String getPreferenciasAlimentarias() {
		return preferenciasAlimentarias;
	}

	public void setPreferenciasAlimentarias(String preferenciasAlientarias) {
		this.preferenciasAlimentarias = preferenciasAlientarias;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
