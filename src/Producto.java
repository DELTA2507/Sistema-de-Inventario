import java.time.LocalDate;
import java.util.ArrayList;

public class Producto {

    //Atributos
    private final int id;
    private String nombre;
    private double costoUnitario;
    private double precio;
    private String categoria;
    private LocalDate fechaVencimiento;
    private ArrayList<String> listaImagenes;

    //Constructor
    public Producto(String nombre, double costoUnitario, double precio, String categoria, LocalDate fechaVencimiento, ArrayList<String> listaImagenes) {
        this.id = GeneradorID.generar();
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.listaImagenes = listaImagenes;
    }

    //Getter & setter
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

    public ArrayList<String> getListaImagenes() {
        return listaImagenes;
    }

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

    public void setListaImagenes(ArrayList<String> listaImagenes) {
        this.listaImagenes = listaImagenes;
    }

    //toString
    @Override
    public String toString() {
        return "\n" +
                "ID: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Costo Unitario: ₡" + costoUnitario + "\n" +
                "Precio: ₡" + precio + "\n" +
                "Categoría: " + categoria + "\n" +
                "Vencimiento: " + fechaVencimiento + "\n" +
                "Imágenes: " + listaImagenes + "\n" +
                "---------------------------------";
    }
}