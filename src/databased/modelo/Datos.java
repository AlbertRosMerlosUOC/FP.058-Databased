package src.databased.modelo;

import java.util.List;

//el controlador solo llamará a los métodos de esta clase.
public class Datos {
    private ListaClientes clientes;
    private ListaArticulos articulos;
    private ListaPedidos pedidos;

    public Datos() {
        this.clientes = new ListaClientes();
        this.articulos = new ListaArticulos();
        this.pedidos = new ListaPedidos();
    }

    public List<Cliente> getClientes() {
        return clientes.getListaClientes();
    }

    public void addCliente(Cliente cliente) {
        clientes.addClienteToModel(cliente);
    }

    public List<Articulo> getArticulos() {
        return articulos.getListaArticulos();
    }

    public void addArticulo(Articulo articulo) {
        articulos.addArticuloToModel(articulo);
    }


    public List<Pedido> getPedidos() {
        return pedidos.getListaPedidos();
    }

    public void addPedido(Pedido pedido) {
        pedidos.addPedidoToModel(pedido);
    }

    public boolean removePedido(int idPedido) {
        //TODO
        return  false;
    }


}
