export class Menu {

    public id: number;
    public nombreMenu: String;
    public entrada: String;
    public platoPrincipal: String;
    public postre: String;
    public bebida: String;
    public tipoMenu: String;
    public precio: number;
    public image: String;
    public cantidad: number;

    constructor (id: number, nombre: String, entrada: String, plato: String, 
        postre: String, bebida: String, precio: number, tipoM: String, image: String){
            this.id = id;
            this.nombreMenu = nombre;
            this.entrada = entrada;
            this.platoPrincipal = plato;
            this.postre = postre;
            this.bebida = bebida;
            this.tipoMenu = tipoM;
            this.precio = precio;
            this.image = image;
            this.cantidad = 0;

        }
}

