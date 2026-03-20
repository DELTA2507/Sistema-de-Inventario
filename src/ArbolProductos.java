import java.time.LocalDate;

public class ArbolProductos {

    //Atributos
    private NodoArbol raiz;

    //Constructor
    public ArbolProductos() {
        this.raiz = null;
    }

    //Getter y setter
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    //Operaciones
    private boolean estaVacia() {
        return raiz == null;
    }

    public NodoArbol buscar(int llave) {
        if (estaVacia()) {
            System.out.println("No hay existencias de inventario.");
            return null;
        }
        NodoArbol temp = raiz;
        while (temp != null && temp.getLlave() != llave) {
            if (temp.getLlave() > llave) temp = temp.getIzquierdo();
            else temp = temp.getDerecho();

        }
        if (temp == null) {
            System.out.println("El producto no está en inventario.");
            return null;
        }
        return temp;
    }

    public void insertar(Producto producto, int stock) {
        NodoArbol nodo = new NodoArbol(producto);
        nodo.setStock(stock);

        if (estaVacia()) {
            raiz = nodo;
            return;
        }
        NodoArbol temp = raiz;
        NodoArbol padreTemp;
        while (true) {
            padreTemp = temp;
            if (temp.getLlave() > nodo.getLlave()) {
                temp = temp.getIzquierdo();
                if (temp == null) {
                    padreTemp.setIzquierdo(nodo);
                    return;
                }
            } else if (temp.getLlave() < nodo.getLlave()) {
                temp = temp.getDerecho();
                if (temp == null) {
                    padreTemp.setDerecho(nodo);
                    return;
                }
            } else {
                System.out.println("El producto ya existe.");
                return;
            }
        }
    }

    public void enOrden(NodoArbol raizTemp) {
        if (raizTemp != null) {
            enOrden(raizTemp.getIzquierdo());
            System.out.print(raizTemp);
            enOrden(raizTemp.getDerecho());
        }
    }

    public void preOrden(NodoArbol raizTemp) {
        if (raizTemp != null) {
            System.out.print(raizTemp.getLlave() + " ");
            preOrden(raizTemp.getIzquierdo());
            preOrden(raizTemp.getDerecho());
        }
    }

    public void postOrden(NodoArbol raizTemp) {
        if (raizTemp != null) {
            postOrden(raizTemp.getIzquierdo());
            postOrden(raizTemp.getDerecho());
            System.out.print(raizTemp.getLlave() + " ");
        }
    }

    private NodoArbol getSucesor(NodoArbol nodo) {
        NodoArbol padreSucesor = nodo;
        NodoArbol sucesor = nodo;
        NodoArbol temp = nodo.getDerecho();

        while (temp != null) {
            padreSucesor = sucesor;
            sucesor = temp;
            temp = temp.getIzquierdo();
        }

        if (sucesor != nodo.getDerecho()) {
            padreSucesor.setIzquierdo(sucesor.getDerecho());
            sucesor.setDerecho(nodo.getDerecho());
        }

        return sucesor;
    }

    private NodoArbol getPadre(int llave) {
        NodoArbol temp = raiz;
        NodoArbol padreTemp = null;

        while (temp != null && temp.getLlave() != llave) {
            padreTemp = temp;

            if (llave < temp.getLlave()) {
                temp = temp.getIzquierdo();
            } else {
                temp = temp.getDerecho();
            }
        }

        if (temp == null) {
            return null;
        }

        return padreTemp;
    }

    public NodoArbol eliminar(NodoArbol nodoEliminar) {
        if (estaVacia()) {
            System.out.println("No hay existencias de inventario.");
            return null;
        }

        NodoArbol nodo = nodoEliminar;
        if (nodo == null) return null;

        if (nodo == raiz) {
            if(nodo.getDerecho() == null && nodo.getIzquierdo() == null) raiz = null;
            else if (nodo.getDerecho() == null) raiz = raiz.getIzquierdo();
            else if (nodo.getIzquierdo() == null) raiz = raiz.getDerecho();
            else {
                NodoArbol sucesor = getSucesor(raiz);
                sucesor.setIzquierdo(raiz.getIzquierdo());
                raiz = sucesor;
            }
            return nodo;
        }
        NodoArbol padreNodo = getPadre(nodoEliminar.getLlave());
        if (nodo.getDerecho() == null && nodo.getIzquierdo() == null) {
            if (nodo == padreNodo.getIzquierdo()) padreNodo.setIzquierdo(null);
            else padreNodo.setDerecho(null);
        } else if (nodo.getDerecho() == null) {
            if (nodo == padreNodo.getIzquierdo()) padreNodo.setIzquierdo(nodo.getIzquierdo());
            else padreNodo.setDerecho(nodo.getIzquierdo());
        } else if (nodo.getIzquierdo() == null) {
            if (nodo == padreNodo.getIzquierdo()) padreNodo.setIzquierdo(nodo.getDerecho());
            else padreNodo.setDerecho(nodo.getDerecho());
        } else {
            NodoArbol sucesor = getSucesor(nodo);
            sucesor.setIzquierdo(nodo.getIzquierdo());
            if (nodo == padreNodo.getIzquierdo()) padreNodo.setIzquierdo(sucesor);
            else padreNodo.setDerecho(sucesor);
        }
        return nodo;
    }

    public void actualizarStock(NodoArbol productoEncontrado, int cantidadActualizar) {

        if (cantidadActualizar <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return;
        }

        productoEncontrado.setStock(cantidadActualizar);

        System.out.println("Stock actualizado correctamente.");
    }

    public void actualizarNombreInventario(NodoArbol productoEncontrado, String nuevoNombre) {

        productoEncontrado.getProducto().setNombre(nuevoNombre);

        System.out.println("Nombre actualizado correctamente.");
    }

    public void actualizarCostoInventario(NodoArbol productoEncontrado, double nuevoCosto) {

        productoEncontrado.getProducto().setCostoUnitario(nuevoCosto);

        System.out.println("Costo unitario actualizado correctamente.");
    }

    public void actualizarPrecioInventario(NodoArbol productoEncontrado, double nuevoPrecio) {

        productoEncontrado.getProducto().setPrecio(nuevoPrecio);

        System.out.println("Precio actualizado correctamente.");
    }

    public void actualizarCategoriaInventario(NodoArbol productoEncontrado, String nuevaCategoria) {

        productoEncontrado.getProducto().setCategoria(nuevaCategoria);

        System.out.println("Categoria actualizada correctamente.");
    }

    public void actualizarVencimientoInventario(NodoArbol productoEncontrado, LocalDate fechaVencimiento) {

        productoEncontrado.getProducto().setFechaVencimiento(fechaVencimiento);

        System.out.println("Fecha de vencimiento actualizada correctamente.");
    }

    public void agregarImagenInventario(NodoArbol productoEncontrado, String rutaImagenNueva) {

        productoEncontrado.getProducto().getListaImagenes().add(rutaImagenNueva);

        System.out.println("Imagen agregada correctamente.");
    }

    public double calcularTotalInventario(NodoArbol nodo) {
        if (nodo == null) return 0;

        double costoNodo = nodo.getProducto().getCostoUnitario() * nodo.getStock();

        return costoNodo
                + calcularTotalInventario(nodo.getIzquierdo())
                + calcularTotalInventario(nodo.getDerecho());
    }

    public boolean reducirStock(int idProducto, int cantidad) {

        NodoArbol nodo = buscar(idProducto);

        if (nodo == null) {
            return false;
        }

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida.");
            return false;
        }

        if (nodo.getStock() < cantidad) {
            System.out.println("Stock insuficiente.");
            return false;
        }

        nodo.setStock(nodo.getStock() - cantidad);

        return true;
    }
}