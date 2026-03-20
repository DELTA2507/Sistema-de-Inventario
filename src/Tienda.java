public class Tienda {

    //Atributos
    private ArbolProductos inventario;
    private ColaClientes colaClientes;

    //Constructor
    public Tienda() {
        this.inventario = new ArbolProductos();
        this.colaClientes = new ColaClientes();
    }

    //Getter & setter
    public ArbolProductos getInventario() {
        return inventario;
    }

    public void setInventario(ArbolProductos inventario) {
        this.inventario = inventario;
    }

    public ColaClientes getColaClientes() {
        return colaClientes;
    }

    public void setColaClientes(ColaClientes colaClientes) {
        this.colaClientes = colaClientes;
    }

    //Operaciones
    public void agregarProductoInventario(Producto producto, int stock) {
        inventario.insertar(producto, stock);
    }

    public void encolarCliente(Cliente cliente) {
        colaClientes.insertarCliente(cliente);
    }

    public Cliente verClienteFrente() {
        return colaClientes.verClienteFrente();
    }

    public Cliente atenderCliente() {
        return colaClientes.atenderCliente();
    }
}