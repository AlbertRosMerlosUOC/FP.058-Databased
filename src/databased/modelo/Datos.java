package databased.modelo;

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
    public List<Cliente> getClientes(String tipoCliente) {
        //TODO
        return null;
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
