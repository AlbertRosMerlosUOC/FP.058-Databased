package src.databased.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes {
    List<Cliente> listaClientes;

    public ListaClientes() {
        this.listaClientes = new ArrayList<>();
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void addClienteToModel(Cliente cliente){
        listaClientes.add(cliente);
    }

}
