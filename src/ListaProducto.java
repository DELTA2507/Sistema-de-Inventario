public class ListaProducto {

    //Atributos
    private NodoLista first;

    //Constructor
    public ListaProducto() {
        this.first = null;
    }

    //Getter y setter
    public NodoLista getFirst() {
        return first;
    }

    private void setFirst(NodoLista first) {
        this.first = first;
    }

    //Operaciones

    private boolean isNull() {
        return first == null;
    }

    public void insertarNodoFinalCarrito(Producto producto, int cantidadComprar, boolean mostrarMensaje) {

        NodoLista nuevoNodo = new NodoLista(producto, cantidadComprar);
        if (isNull()) {
            setFirst(nuevoNodo);
        } else {
            NodoLista temp = first;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
        }

        if (mostrarMensaje) {
            System.out.println("Producto agregado al carrito:");
            System.out.println(nuevoNodo.getProducto());
        }
    }


    public NodoLista buscarNodo(int id) {
        if (isNull()) {
            System.out.println("El carrito está vacío.");
            return null;
        }
        NodoLista temp = first;
        while (temp != null && temp.getProducto().getId() != id) {
            temp = temp.getSiguiente();
        }
        if (temp == null) {
            System.out.println("El producto buscado no se encontró en el carrito.");
        } else {
            System.out.println("El producto buscado se encontró en el carrito.");
        }
        return temp;
    }

    public NodoLista eliminarProducto(int idEliminar) {
        if (isNull()) {
            System.out.println("El carrito está vacío.");
            return null;
        }
        NodoLista temp = first;
        NodoLista anteriorTemp = null;
        while (temp != null && temp.getProducto().getId() != idEliminar) {
            anteriorTemp = temp;
            temp = temp.getSiguiente();
        }
        if (temp == null) {
            System.out.println("El producto no se encontró en el carrito.");
            return null;
        }
        if (anteriorTemp == null) {
            first = temp.getSiguiente();
        } else {
            anteriorTemp.setSiguiente(temp.getSiguiente());
        }
        System.out.println("Producto eliminado del carrito.");
        return temp;
    }

    public void mostrarLista() {
        if (isNull()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        NodoLista temp = first;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getSiguiente();
        }
        System.out.println("Se mostraron todos los productos del carrito.");
    }

    public void actualizarCantidadCarrito(int idProducto, int nuevaCantidad) {
        if (isNull()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        NodoLista temp = first;

        while (temp != null && temp.getProducto().getId() != idProducto) {
            temp = temp.getSiguiente();
        }

        if (temp == null) {
            System.out.println("El producto no se encontró en el carrito.");
            return;
        }

        if (nuevaCantidad <= 0) {
            eliminarProducto(idProducto);
            return;
        }

        temp.setCantidadComprar(nuevaCantidad);

        System.out.println("Cantidad actualizada correctamente.");
    }

    public double calcularTotalCarrito() {

        double sumaTotal = 0;
        NodoLista temp = first;

        while (temp != null) {
            sumaTotal += temp.getProducto().getPrecio() * temp.getCantidadComprar();
            temp = temp.getSiguiente();
        }

        return sumaTotal;
    }

    public void vaciarCarrito() {
        this.first = null;
    }

    //toString
    @Override
    public String toString() {
        if (first == null) {
            return "\n--- Carrito vacío ---";
        }

        String resultado = "\n--- Carrito ---";

        NodoLista temp = first;

        while (temp != null) {
            resultado += temp.toString() + "\n";
            temp = temp.getSiguiente();
        }

        resultado += "Total: ₡" + calcularTotalCarrito() + "\n";
        resultado += "---------------------------------";

        return resultado;
    }
}