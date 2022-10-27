package databased.modelo;

import java.util.ArrayList;
import java.util.List;

//el controlador solo llamará a los métodos de esta clase.
public class Datos {
    private final ListaClientes clientes;
    private final ListaArticulos articulos;
    private final ListaPedidos pedidos;

    public Datos() {
        this.clientes = new ListaClientes();
        this.articulos = new ListaArticulos();
        this.pedidos = new ListaPedidos();
    }

/*    public List<Cliente> getClientes() {
        return (ArrayList<Cliente>) clientes.getArreyList();
    }

    public List<Cliente> getClientes(String tipoCliente) {
        List<Cliente> clientesFiltro = new ArrayList<>();
        for (int i=0; i < clientes.getLista().size(); i++) {
            if ((clientes.getLista().get(i).tipoCliente().equals(tipoCliente))) {
                if (tipoCliente.equals("ClientePremium")) {
                    ClientePremium clienteNuevo = (ClientePremium) clientes.getLista().get(i).clona(clientes.getLista().get(i));
                    clientesFiltro.add(clienteNuevo);
                } else {
                    ClienteStandard clienteNuevo = (ClienteStandard) clientes.getLista().get(i).clona(clientes.getLista().get(i));
                    clientesFiltro.add(clienteNuevo);
                }
            }
        }
        return clientesFiltro;
    }

    public boolean addCliente(Cliente cliente) {
        clientes.add(cliente);
        return true;
    }
*/
    public List<Articulo> getArticulos() {
        return articulos.getArrayList();
    }

    public boolean addArticulo(Articulo articulo){
        return articulos.add(articulo);
    }

/*

    public List<Pedido> getPedidos() {
        return pedidos.getLista();
    }

    public boolean addPedido(Pedido pedido) {
        pedidos.add(pedido);
        return true;
    }

    public boolean deletePedido(int idPedido) {
        //TODO
        return  false;
    }*/


}
