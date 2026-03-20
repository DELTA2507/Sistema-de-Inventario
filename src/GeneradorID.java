public class GeneradorID {

    //Atributos
    private static int contador = 0;

    //Operaciones
    public static int generar() {
        return ++contador;
    }
}