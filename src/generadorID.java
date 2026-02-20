public class generadorID {
    private static int contador = 0;

    public static int generar() {
        return contador++;
    }
}