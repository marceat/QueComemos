package spring.QueComemos.model;
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
import jakarta.validation.constraints.*;


@Entity
@Table(name="VENTA")
public class Venta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade={CascadeType.MERGE})
    @NotNull(message = "El usuario no puede ser nulo")
    private UsuarioGeneral usuario;

    @OneToMany(cascade={CascadeType.MERGE})
    @NotEmpty(message = "La lista de menús no puede estar vacía")
    private List<Menu> menues;

    @OneToMany(cascade={CascadeType.MERGE})
    @NotEmpty(message = "La lista de comidas no puede estar vacía")
    private List<Comida> comidas;

    @NotNull(message = "La fecha no puede ser nula")
    private Date fecha;

    @NotNull(message = "El precio total no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio total debe ser mayor que cero")
    private Double precioTotal;

    @NotBlank(message = "El código QR no puede estar vacío")
    private String qr;

    public Venta() {}

    public Venta(Date unaFecha, Double precio, String qr, UsuarioGeneral us, List<Menu> m, List<Comida> c) {
        this.fecha = unaFecha;
        this.precioTotal = precio;
        this.qr = qr;
        this.usuario = us;
        this.menues = m;
        this.comidas = c;
    }

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

    public List<Menu> getMenues() {
        return menues;
    }

    public void setMenues(List<Menu> menues) {
        this.menues = menues;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
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
