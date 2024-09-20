package packageSubasta;

public class Subasta {

    private String nombre;
    private Double tiempo;

    public Subasta(String nombre) {
        this.nombre = nombre;
    }

    public Subasta(){}

    public Subasta(String nombre, Double tiempo) {
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Double getTiempo() {
        return this.tiempo;
    }
}
