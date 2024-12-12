package spring.QueComemos.model;


import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="CARTA_SEMANAL")
@Component("CartaSemanal")
public class CartaSemanal {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotNull(message = "El id del menú del lunes 1 no puede ser nulo")
    @Min(value = 1, message = "El id del menú del lunes 1 debe ser un valor positivo")
    private int id_menu_lunes_1;

    @NotNull(message = "El id del menú del lunes 2 no puede ser nulo")
    @Min(value = 1, message = "El id del menú del lunes 2 debe ser un valor positivo")
    private int id_menu_lunes_2;

    @NotNull(message = "El id del menú del martes 1 no puede ser nulo")
    @Min(value = 1, message = "El id del menú del martes 1 debe ser un valor positivo")
    private int id_menu_martes_1;

    @NotNull(message = "El id del menú del martes 2 no puede ser nulo")
    @Min(value = 1, message = "El id del menú del martes 2 debe ser un valor positivo")
    private int id_menu_martes_2;

    @NotNull(message = "El id del menú del miércoles 1 no puede ser nulo")
    @Min(value = 1, message = "El id del menú del miércoles 1 debe ser un valor positivo")
    private int id_menu_miercoles_1;

    @NotNull(message = "El id del menú del miércoles 2 no puede ser nulo")
    @Min(value = 1, message = "El id del menú del miércoles 2 debe ser un valor positivo")
    private int id_menu_miercoles_2;

    @NotNull(message = "El id del menú del jueves 1 no puede ser nulo")
    @Min(value = 1, message = "El id del menú del jueves 1 debe ser un valor positivo")
    private int id_menu_jueves_1;

    @NotNull(message = "El id del menú del jueves 2 no puede ser nulo")
    @Min(value = 1, message = "El id del menú del jueves 2 debe ser un valor positivo")
    private int id_menu_jueves_2;

    @NotNull(message = "El id del menú del viernes 1 no puede ser nulo")
    @Min(value = 1, message = "El id del menú del viernes 1 debe ser un valor positivo")
    private int id_menu_viernes_1;

    @NotNull(message = "El id del menú del viernes 2 no puede ser nulo")
    @Min(value = 1, message = "El id del menú del viernes 2 debe ser un valor positivo")
    private int id_menu_viernes_2;

    public CartaSemanal() {}

    public CartaSemanal(int idlun1, int idlun2, int idmar1, int idmar2, int idmie1, int idmie2, int idjue1, int idjue2, int idvie1, int idvie2) {
        this.id_menu_lunes_1 = idlun1;
        this.id_menu_lunes_2 = idlun2;
        this.id_menu_martes_1 = idmar1;
        this.id_menu_martes_2 = idmar2;
        this.id_menu_miercoles_1 = idmie1;
        this.id_menu_miercoles_2 = idmie2;
        this.id_menu_jueves_1 = idjue1;
        this.id_menu_jueves_2 = idjue2;
        this.id_menu_viernes_1 = idvie1;
        this.id_menu_viernes_2 = idvie2;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_menu_lunes_1() {
        return id_menu_lunes_1;
    }

    public void setId_menu_lunes_1(int id_menu_lunes_1) {
        this.id_menu_lunes_1 = id_menu_lunes_1;
    }

    public int getId_menu_lunes_2() {
        return id_menu_lunes_2;
    }

    public void setId_menu_lunes_2(int id_menu_lunes_2) {
        this.id_menu_lunes_2 = id_menu_lunes_2;
    }

    public int getId_menu_martes_1() {
        return id_menu_martes_1;
    }

    public void setId_menu_martes_1(int id_menu_martes_1) {
        this.id_menu_martes_1 = id_menu_martes_1;
    }

    public int getId_menu_martes_2() {
        return id_menu_martes_2;
    }

    public void setId_menu_martes_2(int id_menu_martes_2) {
        this.id_menu_martes_2 = id_menu_martes_2;
    }

    public int getId_menu_miercoles_1() {
        return id_menu_miercoles_1;
    }

    public void setId_menu_miercoles_1(int id_menu_miercoles_1) {
        this.id_menu_miercoles_1 = id_menu_miercoles_1;
    }

    public int getId_menu_miercoles_2() {
        return id_menu_miercoles_2;
    }

    public void setId_menu_miercoles_2(int id_menu_miercoles_2) {
        this.id_menu_miercoles_2 = id_menu_miercoles_2;
    }

    public int getId_menu_jueves_1() {
        return id_menu_jueves_1;
    }

    public void setId_menu_jueves_1(int id_menu_jueves_1) {
        this.id_menu_jueves_1 = id_menu_jueves_1;
    }

    public int getId_menu_jueves_2() {
        return id_menu_jueves_2;
    }

    public void setId_menu_jueves_2(int id_menu_jueves_2) {
        this.id_menu_jueves_2 = id_menu_jueves_2;
    }

    public int getId_menu_viernes_1() {
        return id_menu_viernes_1;
    }

    public void setId_menu_viernes_1(int id_menu_viernes_1) {
        this.id_menu_viernes_1 = id_menu_viernes_1;
    }

    public int getId_menu_viernes_2() {
        return id_menu_viernes_2;
    }

    public void setId_menu_viernes_2(int id_menu_viernes_2) {
        this.id_menu_viernes_2 = id_menu_viernes_2;
    }
}
