public class Producto {
    // Personaje de Fantasia RPG

    // --- Atributos ---
    private final int id;
    private String nombre;
    private String categoria;
    private int cantidad;
    private String imagen;
    Producto siguiente;

    // --- Métodos ---

    // Constructor: Crear un objeto con valores iniciales
    Producto (String nombre, String categoria, int cantidad, String imagen) {
        this.id = generadorID.generar();
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.imagen = imagen;
        this.siguiente = null; // null por defecto, debido a que al ser creado, aun no tiene objeto siguiente
    }

    // Getters: Consultar valor de un atributo
    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public String getCategoria() {return categoria;}
    public int getCantidad() {return cantidad;}
    public String getImagen() {return imagen;}
    public Producto getSiguiente() {
        return siguiente;
    }

    // Setters: Asignar/Modificar valor para un atributo
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setCategoria(String categoria) {this.categoria = categoria;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    public void setImagen(String imagen) {this.imagen = imagen;}
    public void setSiguiente(Producto siguiente) {
        this.siguiente = siguiente;
    }

    // toString(): Rutina para imprimir la info de un objeto de forma cómoda y automática
    @Override
    public String toString() {
        return "Nodo {" +
                "\n id= " + id +
                "\n categoria= "+ categoria +
                "\n nombre= "+ nombre +
                "\n cantidad= "+ cantidad +
                "\n imagen= " + imagen +
                "\n}";
    }
}
