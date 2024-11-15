package spring.QueComemos.model;
import java.awt.Image;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="VENTA")
public class Venta {
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	UsuarioGeneral usuario;
	
	@OneToMany(cascade={CascadeType.MERGE})
	List<Menu> menues;
	
	@OneToMany(cascade={CascadeType.MERGE})
	List<Comida> comidas;
	
	Date fecha;
	Double precioTotal;
	String qr;
	
    public 	Venta() {
		
	}
    
    public Venta(Date unaFecha, Double precio, String qr,UsuarioGeneral us, List<Menu>m,List<Comida>c) {
    	this.fecha=unaFecha;
    	this.precioTotal=precio;
    	this.qr=qr;
    	this.usuario=us;
    	this.menues=m;
    	this.comidas=c;
    }
    
	public List<Comida> getComidas() {
		return comidas;
	}
	public void setComidas(List<Comida> comidas) {
		this.comidas = comidas;
	}
	
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
	public List<Menu> getMenues() {
		return menues;
	}
	public void setMenues(List<Menu> menues) {
		this.menues = menues;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public String getQr() {
		return qr;
	}
	public void setQr(String qr) {
		this.qr = qr;
	}
	
}
