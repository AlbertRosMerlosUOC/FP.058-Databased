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

    public Articulo getArticuloByCodigo(String codigo) {
        return articulos.getArticuloByCodigo(codigo);
    }

    public boolean addArticulo(Articulo articulo){
        return articulos.add(articulo);
    }

    public List<Pedido> getPedidos() {
        return pedidos.getArrayList();
    }

    public Pedido getPedidoById(int idPedido) {
        return pedidos.getPedidoById(idPedido);
    }

    public boolean addPedido(Pedido pedido) {
        return pedidos.add(pedido);
    }

    public boolean deletePedido(Pedido pedido) {
        return pedidos.delete(pedido);
    }
}
