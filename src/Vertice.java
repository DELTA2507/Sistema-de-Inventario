public class Vertice {

    // Atributos
    private final String canton;
    private final int distancia;

    // Métodos
    // Constructor
    public Vertice(String nombre, int distancia) {
        this.canton = nombre;
        this.distancia = distancia;
    }

    // Getters
    public String getCanton() {
        return canton;
    }

    public int getDistancia() {
        return distancia;
    }
}