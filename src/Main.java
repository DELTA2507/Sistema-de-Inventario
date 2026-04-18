import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static PrintStream out = System.out;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static Tienda tienda;
    static Grafo grafo = MapaCantones.crearGrafo();
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        inicializarTienda();

        int opcionInicial;
        cargarProductosPrueba();
        cargarClientesPrueba();

        do {
            try {
                mostrarMenuPrincipal();
                opcionInicial = seleccionarOpcionInicial();
                procesarLogicaMenu(opcionInicial);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                opcionInicial = -1;
            }
        } while (opcionInicial != 0);
    }

    //Inicializar tienda

    public static void inicializarTienda() throws IOException {
        String ubicacionTienda;

        do {
            out.println("Ingrese el cantón central de provincia donde se ubicará la tienda:");
            ubicacionTienda = in.readLine();

            if (!grafo.existeVertice(ubicacionTienda)) {
                out.println("Cantón inválido. Intente nuevamente.");
            }

        } while (!grafo.existeVertice(ubicacionTienda));

        tienda = new Tienda(ubicacionTienda);
    }

    //Funcionalidades de menú

    //Menú principal

    public static void mostrarMenuPrincipal() {
        out.println("\n --- Sistema de Tienda --- ");
        out.println("1. Funcionalidades de gestion de productos");
        out.println("2. Funcionalidades de gestion de clientes");
        out.println("0. Salir");
    }

    public static int seleccionarOpcionInicial() throws IOException {
        int opcionInicial = -1;
        try {
            out.println("Digite la opción a ejecutar:");
            opcionInicial = Integer.parseInt(in.readLine());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return opcionInicial;
    }

    public static void procesarLogicaMenu(int opcionInicial) throws IOException {

        switch (opcionInicial) {

            case 1:
                int opcionProductos;
                do {
                    mostrarMenuProductos();
                    opcionProductos = seleccionarOpcionProductos();
                    procesarLogicaMenuProductos(opcionProductos);
                } while (opcionProductos != 0);
                break;

            case 2:
                int opcionClientes;
                do {
                    mostrarMenuClientes();
                    opcionClientes = seleccionarOpcionClientes();
                    procesarLogicaMenuClientes(opcionClientes);
                } while (opcionClientes != 0);
                break;

            case 0:
                out.println("Saliendo del sistema");
                break;

            default:
                out.println("Opción inválida");
                break;
        }
    }

    //Menú de gestión de productos

    public static void mostrarMenuProductos() {
        out.println("\n --- Funcionalidades de gestion de productos --- ");
        out.println("1. Ingresar producto");
        out.println("2. Buscar producto");
        out.println("3. Modificar producto");
        out.println("4. Eliminar producto");
        out.println("5. Mostrar productos");
        out.println("0. Salir");
    }

    public static int seleccionarOpcionProductos() throws IOException {
        int opcionProductos = -1;
        try {
            out.println("Digite la opción a ejecutar:");
            opcionProductos = Integer.parseInt(in.readLine());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return opcionProductos;
    }

    public static void procesarLogicaMenuProductos(int opcionProductos) throws IOException {

        switch (opcionProductos) {

            case 1:
                ingresarProducto(tienda.getInventario());
                break;

            case 2:
                buscarProducto(tienda.getInventario());
                break;

            case 3:
                modificarProducto(tienda.getInventario());
                break;

            case 4:
                eliminarProducto(tienda.getInventario());
                break;

            case 5:
                mostrarProductos(tienda.getInventario());
                break;

            case 0:
                break;

            default:
                out.println("Opción inválida");
                break;
        }
    }

    //Menú de clientes

    public static void mostrarMenuClientes() {
        out.println("\n --- Funcionalidades de gestion de clientes --- ");
        out.println("1. Agregar cliente");
        out.println("2. Agregar producto al carrito");
        out.println("3. Modificar cantidad en carrito");
        out.println("4. Eliminar producto del carrito");
        out.println("5. Confirmar pedido cliente");
        out.println("6. Atender pedido cliente");
        out.println("7. Mostrar pedidos confirmados");
        out.println("8. Mostrar clientes registrados (con carrito)");
        out.println("0. Salir");
    }

    public static int seleccionarOpcionClientes() throws IOException {
        int opcionClientes = -1;
        try {
            out.println("Digite la opción a ejecutar:");
            opcionClientes = Integer.parseInt(in.readLine());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return opcionClientes;
    }

    public static void procesarLogicaMenuClientes(int opcionClientes) throws IOException {

        switch (opcionClientes) {

            case 1:
                ingresarCliente();
                break;

            case 2:
                ingresarProductoCarrito();
                break;

            case 3:
                modificarProductoCarrito();
                break;

            case 4:
                eliminarProductoCarrito();
                break;

            case 5:
                confirmarPedidoCliente();
                break;

            case 6:
                atenderPedidoCliente();
                break;

            case 7:
                mostrarCarritosConfirmados();
                break;

            case 8:
                mostrarClientesRegistrados();
                break;

            case 0:
                break;

            default:
                out.println("Opción inválida");
                break;
        }
    }

    //Funcionalidades de aplicación

    //Funcionalidades relacionadas con la gestión de productos

    public static void ingresarProducto(ArbolProductos arbolProductos) throws IOException {

        try {
            out.println("Ingrese el nombre del producto:");
            String nombreProducto = in.readLine();

            out.println("Ingrese el costo unitario del producto:");
            double costoUnitario = Double.parseDouble(in.readLine());

            out.println("Ingrese el precio del producto:");
            double precio = Double.parseDouble(in.readLine());

            out.println("Ingrese la categoria del producto:");
            String categoria = in.readLine();

            out.println("Ingrese la fecha de vencimiento (yyyy-mm-dd):");
            LocalDate fechaVencimiento = LocalDate.parse(in.readLine());

            out.println("Ingrese la cantidad del producto:");
            int cantidadProducto = Integer.parseInt(in.readLine());

            out.println("Ingrese la imagen del producto:");
            String rutaImagenProducto = in.readLine();
            ArrayList<String> imagenes = new ArrayList<>();
            imagenes.add(rutaImagenProducto);

            Producto productoIngresar = new Producto(nombreProducto, costoUnitario, precio, categoria, fechaVencimiento, imagenes);
            tienda.agregarProductoInventario(productoIngresar, cantidadProducto);
            out.println("Producto agregado exitosamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void buscarProducto(ArbolProductos arbolProductos) throws IOException {

        try {
            out.println("Ingrese el id del producto que desea buscar:");
            int idProductoBuscar = Integer.parseInt(in.readLine());

            NodoArbol productoEncontrado = arbolProductos.buscar(idProductoBuscar);

            if (productoEncontrado != null) {
                out.println("\nInformación del producto:");
                out.println(productoEncontrado);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void modificarProducto(ArbolProductos arbolProductos) throws IOException {

        try {

            out.println("\nIngrese el id del producto que desea modificar:");
            int idProductoModificar = Integer.parseInt(in.readLine());

            NodoArbol productoEncontrado = arbolProductos.buscar(idProductoModificar);

            if (productoEncontrado != null) {
                out.println("Información del producto:");
                out.println(productoEncontrado);

                int opcionModificar = -1;
                out.println("Ingrese la opción de modificación que desea:");
                out.println("1. Modificar nombre.");
                out.println("2. Modificar costo unitario.");
                out.println("3. Modificar precio.");
                out.println("4. Modificar categoria.");
                out.println("5. Modificar fecha de vencimiento.");
                out.println("6. Modificar cantidad.");
                out.println("7. Agregar una nueva imagen.");
                out.println("0. Salir.");

                opcionModificar = Integer.parseInt(in.readLine());

                switch (opcionModificar) {
                    case 1:
                        out.println("Ingrese el nombre que desea actualizarle al producto:");
                        String nuevoNombre = in.readLine();
                        arbolProductos.actualizarNombreInventario(productoEncontrado, nuevoNombre);
                        break;

                    case 2:
                        out.println("Ingrese el costo unitario que desea actualizarle al producto:");
                        double nuevoCostoUnitario = Double.parseDouble(in.readLine());
                        arbolProductos.actualizarCostoInventario(productoEncontrado, nuevoCostoUnitario);
                        break;

                    case 3:
                        out.println("Ingrese el precio que desea actualizarle al producto:");
                        double nuevoPrecio = Double.parseDouble(in.readLine());
                        arbolProductos.actualizarPrecioInventario(productoEncontrado, nuevoPrecio);
                        break;

                    case 4:
                        out.println("Ingrese la categoria que desea actualizarle al producto:");
                        String nuevaCategoria = in.readLine();
                        arbolProductos.actualizarCategoriaInventario(productoEncontrado, nuevaCategoria);
                        break;

                    case 5:
                        out.println("Ingrese la fecha de vencimiento que desea actualizarle al producto:");
                        LocalDate nuevaFecha = LocalDate.parse(in.readLine());
                        arbolProductos.actualizarVencimientoInventario(productoEncontrado, nuevaFecha);
                        break;

                    case 6:
                        out.println("Ingrese la cantidad que desea actualizarle al producto:");
                        int nuevaCantidad = Integer.parseInt(in.readLine());
                        arbolProductos.actualizarStock(productoEncontrado, nuevaCantidad);
                        break;

                    case 7:
                        out.println("Ingrese el enlace de la nueva imagen que desea agregar al producto:");
                        String nuevaImagen = in.readLine();
                        arbolProductos.agregarImagenInventario(productoEncontrado, nuevaImagen);
                        break;

                    case 0:
                        break;

                    default:
                        out.println("Opción inválida");
                        break;
                }
            } else {
                out.println("No se puede modificar el producto.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void eliminarProducto(ArbolProductos arbolProductos) throws IOException {
        try {
            out.println("Ingrese el id del producto que desea eliminar:");
            int idProductoEliminar = Integer.parseInt(in.readLine());
            NodoArbol productoEncontrado = arbolProductos.buscar(idProductoEliminar);
            if (productoEncontrado != null) {
                out.println("\nInformación del producto:");
                out.println(productoEncontrado);

                int opcionEliminar = -1;

                out.println("¿Esta seguro que desea eliminar al producto?");
                out.println("1. Si, desea eliminar.");
                out.println("2. No, deseo salir.");

                opcionEliminar = Integer.parseInt(in.readLine());

                switch (opcionEliminar) {
                    case 1:
                        if (productoEnCarrito(idProductoEliminar)) {
                            out.println("No se puede eliminar el producto, está en el carrito de un cliente.");
                            return;
                        }

                        arbolProductos.eliminar(productoEncontrado);
                        out.println("El producto fue eliminado con éxito");
                        break;
                    case 2:
                        out.println("El producto no fue eliminado.");
                        break;

                    default:
                        out.println("Opción inválida");
                        break;
                }
            } else {
                out.println("No se puede eliminar el producto.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void mostrarProductos(ArbolProductos arbolProductos) {

        try {

            if (arbolProductos.getRaiz() == null) {
                out.println("El inventario está vacío.");
                return;
            }

            out.println("\n--- Productos en inventario ---");

            arbolProductos.enOrden(arbolProductos.getRaiz());

            double totalInventario = arbolProductos.calcularTotalInventario(arbolProductos.getRaiz());

            out.println("\nCosto total del inventario: ₡" + totalInventario);
            out.println("---------------------------------");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void cargarProductosPrueba() {

        try {

            ArrayList<String> img1 = new ArrayList<>();
            img1.add("arroz.jpg");
            Producto p1 = new Producto(
                    "Arroz 1kg",
                    1200,
                    1500,
                    "Granos",
                    LocalDate.of(2026, 5, 10),
                    img1
            );
            tienda.agregarProductoInventario(p1, 10);

            ArrayList<String> img2 = new ArrayList<>();
            img2.add("leche.jpg");
            Producto p2 = new Producto(
                    "Leche Entera",
                    800,
                    1000,
                    "Lácteos",
                    LocalDate.of(2025, 12, 1),
                    img2
            );
            tienda.agregarProductoInventario(p2, 20);

            ArrayList<String> img3 = new ArrayList<>();
            img3.add("azucar.jpg");
            Producto p3 = new Producto(
                    "Azúcar 2kg",
                    950,
                    1200,
                    "Granos",
                    LocalDate.of(2026, 8, 15),
                    img3
            );
            tienda.agregarProductoInventario(p3, 15);

            ArrayList<String> img4 = new ArrayList<>();
            img4.add("cafe.jpg");
            Producto p4 = new Producto(
                    "Cafe Molido",
                    2500,
                    3000,
                    "Bebidas",
                    LocalDate.of(2027, 3, 20),
                    img4
            );
            tienda.agregarProductoInventario(p4, 5);

            ArrayList<String> img5 = new ArrayList<>();
            img5.add("galletas.jpg");
            Producto p5 = new Producto(
                    "Galletas Chocolate",
                    600,
                    900,
                    "Snacks",
                    LocalDate.of(2025, 11, 30),
                    img5
            );
            tienda.agregarProductoInventario(p5, 30);

            out.println("Productos de prueba cargados correctamente.\n");

        } catch (Exception e) {
            System.out.println("Error al cargar productos de prueba: " + e.getMessage());
        }
    }

    //Funcionalidades para gestionar clientes

    public static void registrarNuevoCanton(String nuevoCanton) throws IOException {

        out.println("El cantón no existe en los registros. Por favor regístrelo.");

        String cantonCentral;
        do {
            out.println("Ingrese el cantón central de provincia al que pertenece:");
            cantonCentral = in.readLine();

            if (!grafo.existeVertice(cantonCentral)) {
                out.println("El cantón central ingresado no existe. Intente nuevamente.");
            }
        } while (!grafo.existeVertice(cantonCentral));

        int distanciaCentral;
        do {
            out.println("Ingrese la distancia entre " + nuevoCanton + " y " + cantonCentral + ":");
            distanciaCentral = Integer.parseInt(in.readLine());

            if (distanciaCentral <= 0) {
                out.println("La distancia debe ser mayor a 0.");
            }
        } while (distanciaCentral <= 0);

        String cantonVecino;
        do {
            out.println("Ingrese el cantón vecino más cercano:");
            cantonVecino = in.readLine();

            if (!grafo.existeVertice(cantonVecino)) {
                out.println("El cantón vecino ingresado no existe. Intente nuevamente.");
            } else if (cantonVecino.equalsIgnoreCase(nuevoCanton)) {
                out.println("El cantón vecino no puede ser el mismo cantón nuevo.");
                cantonVecino = "";
            }
        } while (!grafo.existeVertice(cantonVecino));

        int distanciaVecino;
        do {
            out.println("Ingrese la distancia entre " + nuevoCanton + " y " + cantonVecino + ":");
            distanciaVecino = Integer.parseInt(in.readLine());

            if (distanciaVecino <= 0) {
                out.println("La distancia debe ser mayor a 0.");
            }
        } while (distanciaVecino <= 0);

        grafo.agregarArista(nuevoCanton, cantonCentral, distanciaCentral);
        grafo.agregarArista(nuevoCanton, cantonVecino, distanciaVecino);

        out.println("Cantón registrado correctamente en el grafo.");
    }

    public static void ingresarCliente() throws IOException {

        try {

            out.println("Ingrese la cedula del cliente:");
            String cedula = in.readLine();

            out.println("Ingrese el nombre del cliente:");
            String nombre = in.readLine();

            out.println("Ingrese el primer apellido del cliente:");
            String primerApellido = in.readLine();

            out.println("Ingrese el segundo apellido del cliente:");
            String segundoApellido = in.readLine();

            out.println("Ingrese el teléfono del cliente:");
            String telefono = in.readLine();

            out.println("Ingrese el email del cliente:");
            String email = in.readLine();

            out.println("Ingrese el cantón donde se ubica el cliente:");
            String ubicacion = in.readLine();

            if (!grafo.existeVertice(ubicacion)) {
                registrarNuevoCanton(ubicacion);
            }

            out.println("Ingrese la prioridad del cliente (1-Básicos, 2-Afiliados, 3-Premium):");
            int prioridad = Integer.parseInt(in.readLine());

            Cliente cliente = new Cliente(cedula, nombre, primerApellido, segundoApellido, telefono, email, ubicacion, prioridad);
            clientes.add(cliente);
            out.println("Cliente ingresado correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void ingresarProductoCarrito() throws IOException {

        try {
            out.println("Ingrese su numero de cedula:");
            String cedula = in.readLine();

            Cliente clienteEncontrado = null;

            for (Cliente c : clientes) {
                if (c.getCedula().equals(cedula)) {
                    clienteEncontrado = c;
                    break;
                }
            }

            if (clienteEncontrado == null) {
                out.println("Cliente no registrado, debe registrarse primero.");
                return;
            }

            out.println("Ingrese el id del producto que desea comprar:");
            int idProducto = Integer.parseInt(in.readLine());
            NodoArbol nodoProducto = tienda.getInventario().buscar(idProducto);
            if (nodoProducto == null) {
                return;
            }

            out.println("Ingrese la cantidad que desea agregar al carrito:");
            int cantidad = Integer.parseInt(in.readLine());

            if (!tienda.getInventario().reducirStock(idProducto, cantidad)) {
                return;
            }

            clienteEncontrado.getCarrito().insertarNodoFinalCarrito(
                    nodoProducto.getProducto(),
                    cantidad,true
            );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void modificarProductoCarrito() throws IOException {

        try {
            out.println("Ingrese su numero de cedula:");
            String cedula = in.readLine();

            Cliente clienteEncontrado = null;

            for (Cliente c : clientes) {
                if (c.getCedula().equals(cedula)) {
                    clienteEncontrado = c;
                    break;
                }
            }

            if (clienteEncontrado == null) {
                out.println("Cliente no registrado, debe registrarse primero.");
                return;
            }

            out.println("Ingrese el id del producto:");
            int idProducto = Integer.parseInt(in.readLine());

            NodoLista nodoProducto = clienteEncontrado
                    .getCarrito()
                    .buscarNodo(idProducto);

            if (nodoProducto == null) {
                return;
            }

            out.println("Ingrese la nueva cantidad:");
            int nuevaCantidad = Integer.parseInt(in.readLine());

            int cantidadActual = nodoProducto.getCantidadComprar();
            int diferencia = nuevaCantidad - cantidadActual;

            if (diferencia > 0) {
                if (!tienda.getInventario().reducirStock(idProducto, diferencia)) {
                    return;
                }
            }

            clienteEncontrado.getCarrito()
                    .actualizarCantidadCarrito(idProducto, nuevaCantidad);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void eliminarProductoCarrito() throws IOException {

        try {
            out.println("Ingrese su numero de cedula:");
            String cedula = in.readLine();

            Cliente clienteEncontrado = null;

            for (Cliente c : clientes) {
                if (c.getCedula().equals(cedula)) {
                    clienteEncontrado = c;
                    break;
                }
            }

            if (clienteEncontrado == null) {
                out.println("Cliente no registrado, debe registrarse primero.");
                return;
            }

            out.println("Ingrese el id del producto:");
            int idProducto = Integer.parseInt(in.readLine());

            NodoLista nodoProducto = clienteEncontrado
                    .getCarrito()
                    .buscarNodo(idProducto);

            if (nodoProducto == null) {
                return;
            }

            int cantidad = nodoProducto.getCantidadComprar();

            NodoArbol nodoInventario = tienda.getInventario().buscar(idProducto);
            if (nodoInventario != null) {
                nodoInventario.setStock(
                        nodoInventario.getStock() + cantidad
                );
            }

            clienteEncontrado.getCarrito().eliminarProducto(idProducto);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void confirmarPedidoCliente() throws IOException {

        try {
            out.println("Ingrese su numero de cedula:");
            String cedula = in.readLine();

            Cliente clienteEncontrado = null;

            for (Cliente c : clientes) {
                if (c.getCedula().equals(cedula)) {
                    clienteEncontrado = c;
                    break;
                }
            }

            if (clienteEncontrado == null) {
                out.println("Cliente no registrado, debe registrarse primero.");
                return;
            }

            if (clienteEncontrado.getCarrito().getFirst() == null) {
                return;
            }

            out.println("\n--- Carrito del cliente ---");
            clienteEncontrado.getCarrito().mostrarLista();

            double total = clienteEncontrado.getCarrito().calcularTotalCarrito();
            out.println("Total a pagar: " + total);

            int opcion;

            do {
                out.println("\n¿Desea confirmar el pedido?");
                out.println("1. Sí");
                out.println("2. No");
                opcion = Integer.parseInt(in.readLine());

                if (opcion == 1) {

                    tienda.encolarCliente(clienteEncontrado);

                    out.println("Pedido confirmado. Cliente en cola.");
                    return;

                } else if (opcion == 2) {

                    out.println("Pedido cancelado.");
                    return;

                } else {
                    out.println("Opción inválida, intente nuevamente.");
                }

            } while (true);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void mostrarCarritosConfirmados() {

        if (tienda.getColaClientes().getColaClientes().isEmpty()) {
            System.out.println("No hay pedidos confirmados.");
            return;
        }

        System.out.println("\n--- Pedidos confirmados ---");

        int contador = 1;

        for (Cliente cliente : tienda.getColaClientes().getColaClientes()) {

            System.out.println("\nCliente No. " + contador + ":");

            System.out.println(cliente.toString());

            System.out.println(cliente.getCarrito().toString());

            contador++;
        }
    }

    public static void atenderPedidoCliente() throws IOException {

        try {

            Cliente cliente = tienda.verClienteFrente();

            if (cliente == null) {
                return;
            }

            out.println("\n--- Cliente por atender ---\n");
            out.println("Nombre: " + cliente.getNombre() + " " + cliente.getPrimerApellido());
            out.println("Cédula: " + cliente.getCedula());
            out.println("Prioridad: " + cliente.getPrioridad());

            if (cliente.getCarrito().getFirst() == null) {
                out.println("--- Carrito vacío ---");
                return;
            }

            out.println("\n--- Carrito ---");
            cliente.getCarrito().mostrarLista();

            double total = cliente.getCarrito().calcularTotalCarrito();
            out.println("\nTotal a pagar: " + total);

            String origen = tienda.getUbicacion();
            String destino = cliente.getUbicacion();

            List<String> camino = grafo.obtenerCaminoMasCorto(origen, destino);
            int distancia = grafo.obtenerDistanciaMasCorta(origen, destino);

            out.println("\n--- Ruta más corta ---");
            out.println("Ubicación tienda: " + origen);
            out.println("Ubicación cliente: " + destino);

            if (camino.isEmpty() || distancia == Integer.MAX_VALUE) {
                out.println("No se encontró una ruta disponible.");
            } else {
                out.println("Camino más corto: " + String.join(" -> ", camino));
                out.println("Distancia total: " + distancia + " km");
            }

            int opcion;

            do {
                out.println("\n¿Desea atender este pedido?");
                out.println("1. Sí");
                out.println("2. No");

                opcion = Integer.parseInt(in.readLine());

                if (opcion == 1) {

                    tienda.atenderCliente();

                    cliente.getCarrito().vaciarCarrito();

                    out.println("\nPedido atendido correctamente.");
                    return;

                } else if (opcion == 2) {

                    out.println("\nEl cliente permanece en la cola.");
                    return;

                } else {
                    out.println("\nOpción inválida.");
                }

            } while (true);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void mostrarClientesRegistrados() {

        try {

            if (clientes.isEmpty()) {
                out.println("No hay clientes registrados.\n");
                return;
            }

            out.println("\n--- Clientes registrados ---\n");

            int contador = 1;

            for (Cliente cliente : clientes) {
                out.println("\nCliente No. " + contador + ":");
                out.println(cliente.detalleCompleto());
                contador++;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void cargarClientesPrueba() {

        try {

            //Cliente 1 confirmado
            Cliente c1 = new Cliente("101", "Juan", "Perez", "Lopez", "88881111", "juan@email.com", "San José", 1);

            // Obtener producto 1 desde inventario de tienda
            NodoArbol p1 = tienda.getInventario().buscar(1);

            // Si existe entonces insertarlo en carrito de cliente
            if (p1 != null) {
                c1.getCarrito().insertarNodoFinalCarrito(p1.getProducto(), 2,false);
            }

            // Añadir cliente y poner en cola
            clientes.add(c1);
            tienda.encolarCliente(c1);


            //Cliente 2 confirmado
            Cliente c2 = new Cliente("102", "Maria", "Gomez", "Rojas", "88882222", "maria@email.com", "Barva", 2);

            NodoArbol p2 = tienda.getInventario().buscar(2);
            if (p2 != null) {
                c2.getCarrito().insertarNodoFinalCarrito(p2.getProducto(), 1,false);
            }

            clientes.add(c2);
            tienda.encolarCliente(c2);


            //Cliente 3 confirmado
            Cliente c3 = new Cliente("103", "Carlos", "Ramirez", "Soto", "88883333", "carlos@email.com", "Grecia", 3);

            NodoArbol p3 = tienda.getInventario().buscar(3);
            if (p3 != null) {
                c3.getCarrito().insertarNodoFinalCarrito(p3.getProducto(), 4,false);
            }

            clientes.add(c3);
            tienda.encolarCliente(c3);


            //Cliente 4 por confirmar
            Cliente c4 = new Cliente("104", "Ana", "Torres", "Mora", "88884444", "ana@email.com", "Paraíso", 2);

            NodoArbol p4 = tienda.getInventario().buscar(4);
            if (p4 != null) {
                c4.getCarrito().insertarNodoFinalCarrito(p4.getProducto(), 2,false);
            }

            clientes.add(c4);

            //Cliente 5 carrito vacío
            Cliente c5 = new Cliente("105", "Luis", "Fernandez", "Vargas", "88885555", "luis@email.com", "Esparza", 1);

            clientes.add(c5);

            System.out.println("Clientes de prueba cargados correctamente.");

        } catch (Exception e) {
            System.out.println("Error al cargar clientes de prueba: " + e.getMessage());
        }
    }

    public static boolean productoEnCarrito(int idProducto) {
        for (Cliente c : clientes) {
            if (c.getCarrito().buscarNodoSilencioso(idProducto) != null) {
                return true;
            }
        }
        return false;
    }
}