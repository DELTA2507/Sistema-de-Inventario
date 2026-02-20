public class Lista {
    // --- Atributos ---
    private Producto first;

    // --- Métodos ---

    // Constructor
    public Lista() {
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
    public void insertarNodoInicio (Producto nuevoProducto) {
        Producto nuevoNodo = new Producto(nuevoProducto.getNombre(), nuevoProducto.getCategoria(), nuevoProducto.getImagen());
        nuevoNodo.setSiguiente(first);
        setFirst(nuevoNodo);
    }

    public void insertarNodoFinal (Producto nuevoProducto) {
        Producto nuevoNodo = new Producto(nuevoProducto.getNombre(), nuevoProducto.getCategoria(), nuevoProducto.getImagen());
        if (isNull()) {
            setFirst(nuevoNodo);
            return;
        }
        Producto temp = first;
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        temp.setSiguiente(nuevoNodo);
    }

    public Producto buscarNodo (int id) {

        if (isNull()) {
            System.out.println("La lista está vacía. \n");
            return null;
        }
        Producto nodoActual = first;

        while (nodoActual != null && nodoActual.getId() != id) {
            nodoActual = nodoActual.getSiguiente();
        }
        if (nodoActual ==  null) {
            System.out.println("El nodo buscado NO se encontró en la estructura \n");
        }
        return nodoActual;
    }

    public Producto eliminarProducto(int idEliminar) {

        if (isNull()) {
            System.out.println("LISTA VACIA");
            return null;
        }

        Producto actual = first;
        Producto anterior = null;

        while (actual != null && actual.getId() != idEliminar) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            System.out.println("NODO NO ENCONTRADO");
            return null;
        }

        if (anterior == null) {
            first = actual.getSiguiente();
        } else {
            anterior.setSiguiente(actual.getSiguiente());
        }

        System.out.println("\n --------------------------");
        System.out.println("PRODUCTO ELIMINADO CON ÉXITO");
        System.out.println("-----------------------------");

        return actual;
    }

    public Producto mostrarLista() {
        if (isNull()) {
            System.out.println("La lista está vacía. \n");
            return null;
        }
        Producto nodoActual = first;

        while (nodoActual != null) {
            System.out.println(nodoActual);
            nodoActual = nodoActual.getSiguiente();
        }
        return nodoActual;
    }

    public boolean actualizarNombre(int id, String nuevoNombre) {
        Producto actual = buscarNodo(id);
        if (actual == null) {
            return false;
        }
        actual.setNombre(nuevoNombre);
        return true;
    }

    public boolean actualizarCategoria(int id, String nuevaCategoria) {
        Producto actual = buscarNodo(id);
        if (actual == null) {
            return false;
        }
        actual.setCategoria(nuevaCategoria);
        return true;
    }

    public boolean actualizarImagen(int id, String nuevaImagen) {
        Producto actual = buscarNodo(id);
        if (actual == null) {
            return false;
        }
        actual.setImagen(nuevaImagen);
        return true;
    }



    private boolean isNull() {
        return first == null;
    }
}
