import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    static PrintStream out = System.out;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static ListaProducto listaProductos = new ListaProducto();

    public static void main(String[] args) throws IOException {

        cargarProductosPrueba();

        //Lógica de la aplicación
        int opcionInicial = -1;

        do {
            try {
                mostrarMenuPrincipal();
                opcionInicial = seleccionarOpcionInicial();
                procesarLogicaMenu(opcionInicial);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcionInicial != 0);
    }

    //Métodos relacionados con la funcionalidad del menú

    public static void mostrarMenuPrincipal() {
        out.println("\n --- Sistema de Inventario --- ");
        out.println("1. Ingresar producto");
        out.println("2. Buscar producto");
        out.println("3. Modificar producto");
        out.println("4. Mostrar lista de productos");
        out.println("5. Eliminar producto");
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
                IngresarProducto(listaProductos);
                break;

            case 2:
                BuscarProducto(listaProductos);
                break;

            case 3:
                ModificarProducto(listaProductos);
                break;

            case 4:
                MostrarLista(listaProductos);
                break;

            case 5:
                EliminarProducto(listaProductos);
                break;

            case 0:
                break;

            default:
                out.println("Opción inválida");
                break;
        }
    }

    //Metodos sobre las funcionalidades solicitadas

    public static void IngresarProducto(ListaProducto listaProductos) throws IOException {

        try {
            //String nombre, double costoUnitario, double precio, String categoria, LocalDate fechaVencimiento, int cantidad, ArrayList<String> listaImagenes
            out.println("Ingrese el nombre del producto:");
            String nombreProducto = in.readLine();

            out.println("Ingrese el costo unitario del producto:");
            double costoUnitario = Double.parseDouble(in.readLine());

            out.println("Ingrese el precio del producto:");
            double precio = Double.parseDouble(in.readLine());

            out.println("Ingrese la categoria del producto:");
            String categoria = in.readLine();

            out.println("Ingrese la fecha de vencimiento (yyyy-MM-dd):");
            LocalDate fechaVencimiento = LocalDate.parse(in.readLine());

            out.println("Ingrese la cantidad del producto:");
            int cantidadProducto = Integer.parseInt(in.readLine());

            out.println("Ingrese la imagen del producto:");
            String rutaImagenProducto = in.readLine();
            ArrayList<String> imagenes = new ArrayList<>();
            imagenes.add(rutaImagenProducto);

            int opcionIngreso = -1;

            out.println("Digite la opcion donde desea ingresar el producto:");
            out.println("1. Al incio de la lista.");
            out.println("2. Al final de la lista.");
            out.println("0. Salir.");
            opcionIngreso = Integer.parseInt(in.readLine());

            switch (opcionIngreso) {
                case 1:
                    listaProductos.insertarNodoInicio(nombreProducto, costoUnitario, precio, categoria, fechaVencimiento, cantidadProducto, imagenes);
                    break;
                case 2:
                    listaProductos.insertarNodoFinal(nombreProducto, costoUnitario, precio, categoria, fechaVencimiento, cantidadProducto, imagenes);
                    break;

                case 0:
                    out.println("El producto no fue agregado en la lista.\n");
                    break;

                default:
                    out.println("Opción inválida");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void BuscarProducto(ListaProducto listaProductos) throws IOException {

        try {

            out.println("Ingrese el id del producto que desea buscar:");
            int idProductoBuscar = Integer.parseInt(in.readLine());

            Producto productoEncontrado = listaProductos.buscarNodo(idProductoBuscar);

            if (productoEncontrado != null) {
                out.println("Información del producto:");
                out.println(productoEncontrado.toString());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void ModificarProducto(ListaProducto listaProductos) throws IOException {

        try {

            out.println("Ingrese el id del producto que desea modificar:");
            int idProductoModificar = Integer.parseInt(in.readLine());

            Producto productoEncontrado = listaProductos.buscarNodo(idProductoModificar);

            if (productoEncontrado != null) {
                out.println("Información del producto:");
                out.println(productoEncontrado.toString());

                int opcionModificar = -1;
                //String nombre, double costoUnitario, double precio, String categoria, LocalDate fechaVencimiento, int cantidad, ArrayList<String> listaImagenes
                out.println("Ingrese la opcion de modificacion que desea:");
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
                        listaProductos.actualizarNombre(productoEncontrado, nuevoNombre);
                        break;

                    case 2:
                        out.println("Ingrese el costo unitario que desea actualizarle al producto:");
                        double nuevoCostoUnitario = Double.parseDouble(in.readLine());
                        listaProductos.actualizarCostoUnitario(productoEncontrado, nuevoCostoUnitario);
                        break;

                    case 3:
                        out.println("Ingrese el precio que desea actualizarle al producto:");
                        double nuevoPrecio = Double.parseDouble(in.readLine());
                        listaProductos.actualizarPrecio(productoEncontrado, nuevoPrecio);
                        break;

                    case 4:
                        out.println("Ingrese la categoria que desea actualizarle al producto:");
                        String nuevaCategoria = in.readLine();
                        listaProductos.actualizarCategoria(productoEncontrado, nuevaCategoria);
                        break;

                    case 5:
                        out.println("Ingrese la fecha de vencimiento que desea actualizarle al producto:");
                        LocalDate nuevaFecha = LocalDate.parse(in.readLine());
                        listaProductos.actualizarFechaVencimiento(productoEncontrado, nuevaFecha);
                        break;

                    case 6:
                        out.println("Ingrese la cantidad que desea actualizarle al producto:");
                        int nuevaCantidad = Integer.parseInt(in.readLine());
                        listaProductos.actualizarCantidad(productoEncontrado, nuevaCantidad);
                        break;

                    case 7:
                        out.println("Ingrese el enlace de la nueva imagen que desea agregar al producto:");
                        String nuevaImagen = in.readLine();
                        listaProductos.agregarImagen(productoEncontrado, nuevaImagen);
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

    public static void EliminarProducto(ListaProducto listaProductos) throws IOException {

        try {
            //String nombre, double costoUnitario, double precio, String categoria, LocalDate fechaVencimiento, int cantidad, ArrayList<String> listaImagenes
            out.println("Ingrese el id del producto que desea eliminar:");
            int idProductoEliminar = Integer.parseInt(in.readLine());

            Producto productoEncontrado = listaProductos.buscarNodo(idProductoEliminar);

            if (productoEncontrado != null) {
                out.println("Información del producto:");
                out.println(productoEncontrado.toString());

                int opcionEliminar = -1;

                out.println("Esta seguro que desea eliminar al producto?");
                out.println("1. Si, desea eliminar.");
                out.println("2. No, deseo salir.");

                opcionEliminar = Integer.parseInt(in.readLine());

                switch (opcionEliminar) {
                    case 1:
                        listaProductos.eliminarProducto(productoEncontrado.getId());
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

    public static void MostrarLista(ListaProducto listaProductos) throws IOException {

        try {
            listaProductos.mostrarLista();
            double totalInventario = listaProductos.calcularCostoTotalInventario();
            out.println("Costo total del inventario: " + totalInventario);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void cargarProductosPrueba() {

        ArrayList<String> img1 = new ArrayList<>();
        img1.add("arroz.jpg");
        listaProductos.insertarNodoFinal("Arroz 1kg",1200,1500,"Granos",LocalDate.of(2026,5,10),10,img1);

        ArrayList<String> img2 = new ArrayList<>();
        img2.add("leche.jpg");
        listaProductos.insertarNodoFinal("Leche Entera",800,1000,"Lacteos",LocalDate.of(2025,12,1),20,img2);

        ArrayList<String> img3 = new ArrayList<>();
        img3.add("azucar.jpg");
        listaProductos.insertarNodoFinal("Azucar 2kg",950,1200,"Granos",LocalDate.of(2026,8,15),15,img3);

        ArrayList<String> img4 = new ArrayList<>();
        img4.add("cafe.jpg");
        listaProductos.insertarNodoFinal("Cafe Molido",2500,3000,"Bebidas",LocalDate.of(2027,3,20),5,img4);

        ArrayList<String> img5 = new ArrayList<>();
        img5.add("galletas.jpg");
        listaProductos.insertarNodoFinal("Galletas Chocolate",600,900,"Snacks",LocalDate.of(2025,11,30),30,img5);
    }
}