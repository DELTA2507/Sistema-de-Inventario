public class NodoArbol {

    //Atributos
    private final int llave;
    private Producto producto;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    int stock;

    //Constructor
    public NodoArbol(Producto producto) {
        this.llave = producto.getId();
        this.producto = producto;
        this.izquierdo = null;
        this.derecho = null;
        this.stock = 0;
    }

    //Getter y setter
    public int getLlave() {
        return llave;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //toString
    @Override
    public String toString() {

        double costoTotal = producto.getCostoUnitario() * stock;

        return "\n" +
                "ID: " + producto.getId() + "\n" +
                "Nombre: " + producto.getNombre() + "\n" +
                "Stock: " + stock + "\n" +
                "Costo Unitario: ₡" + producto.getCostoUnitario() + "\n" +
                "Costo Total Inventario: ₡" + costoTotal + "\n" +
                "Precio Venta: ₡" + producto.getPrecio() + "\n" +
                "Categoría: " + producto.getCategoria() + "\n" +
                "Vencimiento: " + producto.getFechaVencimiento() + "\n" +
                "---------------------------------";
    }
}