package spring.QueComemos.model;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Entity
@Table(name="MENU")
@Component("Menu")
public class Menu {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nombreMenu;
	private String entrada;
	private String platoPrincipal;
	private String postre;
	private String bebida;
	private String tipoMenu; //Vegetariano, no vegetariano, sin gluten, sin restricciones.
	private int precio;
	
	public Menu () {}
	
	public Menu (String n, String e, String plato, String postre, String b, String t, int precio) {
		this.setNombreMenu(n);
		this.setEntrada(e);
		this.setPlatoPrincipal(plato);
		this.setPostre(postre);
		this.setBebida(b);
		this.setTipoMenu(t);
		this.setPrecio(precio);
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getPlatoPrincipal() {
		return platoPrincipal;
	}

	public void setPlatoPrincipal(String platoPrincipal) {
		this.platoPrincipal = platoPrincipal;
	}

	public String getPostre() {
		return postre;
	}

	public void setPostre(String postre) {
		this.postre = postre;
	}

	public String getBebida() {
		return bebida;
	}

	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreMenu() {
		return nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public String getTipoMenu() {
		return tipoMenu;
	}

	public void setTipoMenu(String tipoMenu) {
		this.tipoMenu = tipoMenu;
	}
	
	
}
