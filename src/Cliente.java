public class Cliente {

    //Atributos
    private String cedula;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String email;
    private String ubicacion;
    private int prioridad;
    ListaProducto carrito;

    //Constructor
    public Cliente(String cedula, String nombre, String primerApellido, String segundoApellido, String telefono, String email, String ubicacion, int prioridad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.email = email;
        this.ubicacion = ubicacion;
        this.prioridad = prioridad;
        this.carrito = new ListaProducto();
    }

    //Getter & setter
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public ListaProducto getCarrito() {
        return carrito;
    }

    public void setCarrito(ListaProducto carrito) {
        this.carrito = carrito;
    }

    //toString
    @Override
    public String toString() {
        return "\n" +
                "Nombre: " + nombre + " " + primerApellido + " " + segundoApellido + "\n" +
                "Cédula: " + cedula + "\n" +
                "Teléfono: " + telefono + "\n" +
                "Email: " + email + "\n" +
                "Ubicación: " + ubicacion + "\n" +
                "Prioridad: " + prioridad;
    }

    public String detalleCompleto() {
        return toString() + carrito.toString();
    }
}