public class NodoLista {

    //Atributos
    Producto producto;
    NodoLista siguiente;
    int cantidadComprar;

    //Constructor
    public NodoLista(Producto producto, int cantidadComprar) {
        this.cantidadComprar = cantidadComprar;
        this.siguiente = null;
        this.producto = producto;
    }

    //Getter & setter
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }

    public int getCantidadComprar() {
        return cantidadComprar;
    }

    public void setCantidadComprar(int cantidadComprar) {
        this.cantidadComprar = cantidadComprar;
    }

    //toString
    @Override
    public String toString() {

        double total = producto.getPrecio() * cantidadComprar;

        return "\n" +
                "ID: " + producto.getId() + "\n" +
                "Producto: " + producto.getNombre() + "\n" +
                "Cantidad: " + cantidadComprar + "\n" +
                "Precio Unitario: ₡" + producto.getPrecio() + "\n" +
                "Subtotal: ₡" + total + "\n" +
                "---------------------------------";
    }
}