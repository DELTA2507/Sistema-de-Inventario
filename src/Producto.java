import java.time.LocalDate;
import java.util.ArrayList;

public class Producto {

    // --- Atributos ---
    private final int id;
    private String nombre;
    private double costoUnitario;
    private double precio;
    private String categoria;
    private LocalDate fechaVencimiento;
    private int cantidad;
    private ArrayList<String> listaImagenes;
    private Producto siguiente;

    // --- Métodos ---

    // Constructor: Crear un objeto con valores iniciales
    public Producto(String nombre, double costoUnitario, double precio, String categoria, LocalDate fechaVencimiento, int cantidad, ArrayList<String> listaImagenes) {
        this.id = generadorID.generar();
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.listaImagenes = listaImagenes;
        this.siguiente = null; // null por defecto, debido a que al ser creado, aun no tiene objeto siguiente
    }

    // Getters: Consultar valor de un atributo
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getCostoTotal() {
        return costoUnitario * cantidad;
    }

    public ArrayList<String> getListaImagenes() {
        return listaImagenes;
    }

    public Producto getSiguiente() {
        return siguiente;
    }

    // Setters: Asignar/Modificar valor para un atributo
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setListaImagenes(ArrayList<String> listaImagenes) {
        this.listaImagenes = listaImagenes;
    }

    public void setSiguiente(Producto siguiente) {
        this.siguiente = siguiente;
    }

    // toString(): Rutina para imprimir la info de un objeto de forma cómoda y automática
    @Override
    public String toString() {

        double costoTotal = costoUnitario * cantidad;

        return "\nId=" + id +
                "\nNombre='" + nombre + '\'' +
                "\nCosto unitario=" + costoUnitario +
                "\nCantidad=" + cantidad +
                "\nCosto total=" + costoTotal +
                "\nPrecio=" + precio +
                "\nCategoria='" + categoria + '\'' +
                "\nFecha de vencimiento=" + fechaVencimiento +
                "\nLista de imagenes=" + listaImagenes +"\n";
    }
}