package databased.modelo;

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
        return clientes.getArrayList();
    }

    public List<Cliente> getClientes(String tipoCliente) {
        return clientes.getClientes(tipoCliente);
    }

    public Cliente getClienteByEmail(String email) {
        return clientes.getClienteByEmail(email);
    }

    public boolean addCliente(Cliente cliente) {
        return clientes.add(cliente);
    }

    public List<Articulo> getArticulos() {
        return articulos.getArrayList();
    }

    public boolean addArticulo(Articulo articulo){
        return articulos.add(articulo);
    }

    public List<Pedido> getPedidos() {
        return pedidos.getArrayList();
    }

    public boolean addPedido(Pedido pedido) {
        pedidos.add(pedido);
        return true;
    }

    public boolean deletePedido(int idPedido) {
        //TODO
        return  false;
    }
}
