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

    public List<Cliente> getClientes() {
        return clientes.getListaClientes();
    }

    public List<Cliente> getClientes(String tipoCliente) {
        List<Cliente> clientesFiltro = new ArrayList<>();
        for (int i=0; i < clientes.listaClientes.size(); i++) {
            if ((clientes.listaClientes.get(i).tipoCliente().equals(tipoCliente))) {
                if (tipoCliente.equals("ClientePremium")) {
                    ClientePremium clienteNuevo = (ClientePremium) clientes.listaClientes.get(i).clona(clientes.listaClientes.get(i));
                    clientesFiltro.add(clienteNuevo);
                } else {
                    ClienteStandard clienteNuevo = (ClienteStandard) clientes.listaClientes.get(i).clona(clientes.listaClientes.get(i));
                    clientesFiltro.add(clienteNuevo);
                }
            }
        }
        return clientesFiltro;
    }

    public boolean addCliente(Cliente cliente) {
        clientes.addClienteToModel(cliente);
        return true;
    }

    public List<Articulo> getArticulos() {
        return articulos.getListaArticulos();
    }

    public boolean addArticulo(Articulo articulo) {
        articulos.addArticuloToModel(articulo);
        return  true;
    }


    public List<Pedido> getPedidos() {
        return pedidos.getListaPedidos();
    }

    public boolean addPedido(Pedido pedido) {
        pedidos.addPedidoToModel(pedido);
        return true;
    }

    public boolean deletePedido(int idPedido) {
        //TODO
        return  false;
    }


}
