import java.time.LocalDate;
import java.util.ArrayList;

public class ListaProducto {
    // Atributos
    private Producto first;

    // Métodos

    // Constructor
    public ListaProducto() {
        this.first = null;
    }

    // Getters
    public Producto getFirst() {
        return first;
    }

    // Setters
    private void setFirst(Producto first) {
        this.first = first;
    }

    // Operaciones
    public void insertarNodoInicio(String nombre, double costoUnitario, double precio, String categoria, LocalDate fechaVencimiento, int cantidad, ArrayList<String> listaImagenes) {

        Producto nuevoNodo = new Producto(nombre, costoUnitario, precio, categoria, fechaVencimiento, cantidad, listaImagenes);
        nuevoNodo.setSiguiente(first);
        System.out.println("Producto ingresado con éxito. Id asignado:" + nuevoNodo.getId());
        setFirst(nuevoNodo);
    }

    private boolean isNull() {
        return first == null;
    }

    public void insertarNodoFinal(String nombre, double costoUnitario, double precio, String categoria, LocalDate fechaVencimiento, int cantidad, ArrayList<String> listaImagenes) {

        Producto nuevoNodo = new Producto(nombre, costoUnitario, precio, categoria, fechaVencimiento, cantidad, listaImagenes);
        if (isNull()) {
            setFirst(nuevoNodo);
        } else {
            Producto temp = first;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
        }
        System.out.println("Producto ingresado con éxito. ID asignado:" + nuevoNodo.getId());
    }

    public Producto buscarNodo(int id) {

        if (isNull()) {
            System.out.println("La lista está vacía.\n");
            return null;
        }
        Producto temp = first;
        while (temp != null && temp.getId() != id) {
            temp = temp.getSiguiente();
        }
        if (temp == null) {
            System.out.println("El producto buscado no se encontró en la lista.\n");
        } else {
            System.out.println("El producto buscado se encontró en la lista.\n");
        }
        return temp;
    }

    public Producto eliminarProducto(int idEliminar) {

        if (isNull()) {
            System.out.println("La lista esta vacia.\n");
            return null;
        }
        Producto temp = first;
        Producto anteriorTemp = null;
        while (temp != null && temp.getId() != idEliminar) {
            anteriorTemp = temp;
            temp = temp.getSiguiente();
        }
        if (temp == null) {
            System.out.println("El código no se encontró en la lista.\n");
            return null;
        }
        if (anteriorTemp == null) {
            first = temp.getSiguiente();
        } else {
            anteriorTemp.setSiguiente(temp.getSiguiente());
        }
        System.out.println("Producto eliminado con exito.\n");
        return temp;
    }

    public Producto mostrarLista() {

        if (isNull()) {
            System.out.println("La lista está vacía. \n");
            return null;
        }
        Producto temp = first;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getSiguiente();
        }
        System.out.println("Se imprimieron todos los productos.\n");
        return temp;
    }

    public void actualizarNombre(Producto productoActualizar, String nombreActualizar) {
        productoActualizar.setNombre(nombreActualizar);
        System.out.println("El nombre del producto fue actualizado con exito.\n");
    }

    public void actualizarCostoUnitario(Producto productoActualizar, double costoActualizar) {
        productoActualizar.setCostoUnitario(costoActualizar);
        System.out.println("El costo del producto fue actualizado con exito.\n");
    }

    public void actualizarPrecio(Producto productoActualizar, double precioActualizar) {
        productoActualizar.setPrecio(precioActualizar);
        System.out.println("El precio del producto fue actualizado con exito.\n");
    }

    public void actualizarCategoria(Producto productoActualizar, String categoriaActualizar) {
        productoActualizar.setCategoria(categoriaActualizar);
        System.out.println("La categoria del producto fue actualizada con exito.\n");
    }

    public void actualizarFechaVencimiento(Producto productoActualizar, LocalDate fechaActualizar) {
        productoActualizar.setFechaVencimiento(fechaActualizar);
        System.out.println("La fecha de vencimiento del producto fue actualizada con exito.\n");
    }

    public void actualizarCantidad(Producto productoActualizar, int cantidadActualizar) {
        productoActualizar.setCantidad(cantidadActualizar);
        System.out.println("La cantidad del producto fue actualizada con exito.\n");
    }

    public void agregarImagen(Producto productoActualizar, String rutaImagenNueva) {
        productoActualizar.getListaImagenes().add(rutaImagenNueva);
        System.out.println("La imagen del producto fue agregada con exito.\n");
    }

    public double calcularCostoTotalInventario() {

        double sumaTotal = 0;

        Producto temp = first;

        while (temp != null) {
            sumaTotal += temp.getCostoTotal();
            temp = temp.getSiguiente();
        }

        return sumaTotal;
    }
}