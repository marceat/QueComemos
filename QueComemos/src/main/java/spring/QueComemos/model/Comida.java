package spring.QueComemos.model;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Entity
@Table(name="comida")
@Component
public class Comida {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String nombre;
	int precio;
	int stock;
	
	public Comida () {}
	
	public Comida(String n, int p, int s) {
		this.setNombre(n);
		this.setPrecio(p);
		this.setStock(s);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
