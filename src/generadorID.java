public class generadorID {
    private static int contador = 1;

    public static int generar() {
        return contador++;
    }
}