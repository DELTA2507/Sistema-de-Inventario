import java.util.ArrayList;

public class ColaClientes {

    //Atributos
    private ArrayList<Cliente> colaClientes;

    //Constructor
    public ColaClientes() {
        this.colaClientes = new ArrayList<>();
    }

    //Getter & setter

    public ArrayList<Cliente> getColaClientes() {
        return colaClientes;
    }

    public void setColaClientes(ArrayList<Cliente> colaClientes) {
        this.colaClientes = colaClientes;
    }

    //Operaciones

    public Cliente insertarCliente(Cliente cliente) {
        int i = 0;

        while (i < colaClientes.size()) {

            Cliente actual = colaClientes.get(i);

            if (cliente.getPrioridad() < actual.getPrioridad()) {
                break;
            }

            i++;
        }

        colaClientes.add(i, cliente);

        return cliente;
    }

    public Cliente atenderCliente() {
        if (colaClientes.isEmpty()) {
            System.out.println("No hay clientes pendientes de atender.");
            return null;
        }
        return colaClientes.removeFirst();
    }

    public Cliente verClienteFrente(){
        if(colaClientes.isEmpty()) {
            System.out.println("No hay clientes pendientes de atender.");
            return null;
        }
        return colaClientes.getFirst();
    }
}