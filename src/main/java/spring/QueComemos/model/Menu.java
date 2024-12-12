package spring.QueComemos.model;


import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="MENU")
@Component("Menu")
public class Menu {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotBlank(message = "El nombre del menú no puede estar vacío")
    private String nombreMenu;

    @NotBlank(message = "La entrada no puede estar vacía")
    private String entrada;

    @NotBlank(message = "El plato principal no puede estar vacío")
    private String platoPrincipal;

    @NotBlank(message = "El postre no puede estar vacío")
    private String postre;

    @NotBlank(message = "La bebida no puede estar vacía")
    private String bebida;

    @NotBlank(message = "El tipo de menú no puede estar vacío")
    private String tipoMenu; // Vegetariano, no vegetariano, sin gluten, sin restricciones.

    @NotNull(message = "El precio no puede ser nulo")
    @Min(value = 0, message = "El precio debe ser mayor o igual a cero")
    private int precio;

    public Menu() {}

    public Menu(String n, String e, String plato, String postre, String b, String t, int precio) {
        this.setNombreMenu(n);
        this.setEntrada(e);
        this.setPlatoPrincipal(plato);
        this.setPostre(postre);
        this.setBebida(b);
        this.setTipoMenu(t);
        this.setPrecio(precio);
    }

    // Getters y Setters
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

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

