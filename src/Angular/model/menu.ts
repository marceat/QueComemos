export class Menu {

    public id: number;
    public nombreMenu: string;
    public entrada: string;
    public platoPrincipal: string;
    public postre: string;
    public bebida: string;
    public tipoMenu: string;
    public precio: number;

    constructor (id: number, nombre: string, entrada: string, plato: string, 
        postre: string, bebida: string, precio: number, tipoM: string){
            this.id = id;
            this.nombreMenu = nombre;
            this.entrada = entrada;
            this.platoPrincipal = plato;
            this.postre = postre;
            this.bebida = bebida;
            this.tipoMenu = tipoM;
            this.precio = precio;
        }
}

