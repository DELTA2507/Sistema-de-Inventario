import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    static void main(String[] args) {
        Lista listaProductos = new Lista();
        int opcionMenu = 0;
        boolean salir = false;

        while (!salir) {
            opcionMenu = menu(listaProductos);
            switch (opcionMenu) {
                case 1: {
                    System.out.print(listaProductos.mostrarLista());
                    break;
                }

                case 2: {
                    int id = 0;
                    System.out.println("Introduzca el ID del producto que desea buscar");
                    id = scanner.nextInt();
                    System.out.print(listaProductos.buscarNodo(id));

                    break;
                }

                case 3: {
                    int opcion = 0;
                    System.out.print("Donde desea introducir el nuevo producto?");
                    System.out.print("1. Al inicio de la lista");
                    System.out.print("2. Al final de la lista");
                    opcion = scanner.nextInt();

                    Producto nuevo = crearProducto();

                    if (opcion == 1) {
                        listaProductos.insertarNodoInicio(nuevo);
                    } else if (opcion == 2) {
                        listaProductos.insertarNodoFinal(nuevo);
                    }

                    break;
                }

                case 4: {
                    System.out.print("Ingrese el ID del producto a modificar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Producto existente = listaProductos.buscarNodo(id);

                    if (existente == null) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }

                    System.out.println("Producto encontrado:");
                    System.out.println(existente);

                    System.out.println("1. Nombre");
                    System.out.println("2. Imagen");

                    int opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {

                        case 1:
                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = scanner.nextLine();
                            listaProductos.actualizarNombre(id, nuevoNombre);
                            break;

                        case 2:
                            System.out.print("Nueva imagen: ");
                            String nuevaImagen = scanner.nextLine();
                            listaProductos.actualizarImagen(id, nuevaImagen);
                            break;

                        default:
                            System.out.println("Opción inválida");
                    }

                    break;
                }

                case 5: {
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Producto existente = listaProductos.buscarNodo(id);

                    if (existente == null) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }

                    System.out.println("Producto encontrado:");
                    System.out.println(existente);

                    System.out.println("Seguro que desea eliminar el producto? (Y/N)");
                    String opcion = scanner.nextLine().trim().toUpperCase();

                    if (opcion.equals("Y")) {
                        listaProductos.eliminarProducto(id);
                    } else if (opcion.equals("N")) {
                        return;
                    }

                    break;
                }

                case 6: {
                    salir = true;
                    break;
                }
            }
        }
    }

    private static int menu(Lista listaProductos) {
        int opcionMenu = 0;

        System.out.print("--- Sistema de Inventario ---");
        System.out.println("Seleccione una opción (Introduzca el número correspondiente a la opción deseada):");
        System.out.println("1. Mostrar Lista de Productos");
        System.out.println("2. Buscar Producto");
        System.out.println("3. Insertar Producto");
        System.out.println("4. Editar Producto");
        System.out.println("5. Eliminar Producto");
        System.out.println("6. Salir");

        opcionMenu = scanner.nextInt();

        return opcionMenu;
    }

    private static Producto crearProducto() {
        System.out.println("Introduzca la información del nuevo producto");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Imagen: ");
        String imagen = scanner.nextLine();

        return new Producto(nombre, imagen);
    }
}