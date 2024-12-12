package spring.QueComemos.model;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.validation.*;
import jakarta.validation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="comida")
@Component
public class Comida {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@NotBlank(message="El campo nombre no puede estar vacio.")
	@NotNull(message="Falta el campo precio.")
	private String nombre;
	
	@NotNull(message="Falta el campo precio.")
	private int precio;
	
	@NotNull(message="Falta el campo stock.")
	private int stock;
	
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
