package databased.modelo;

import databased.dao.ArticuloDAO;

import java.util.List;

//el controlador solo llamará a los métodos de esta clase.
public class Datos {
    private final ListaClientes clientes;
    //private final ListaArticulos articulos;
    private final ListaPedidos pedidos;

    private final ArticuloDAO articuloDAO;

    public Datos() {

        this.clientes = new ListaClientes();
        //this.articulos = new ListaArticulos();
        this.pedidos = new ListaPedidos();

        this. articuloDAO = new ArticuloDAO();


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
        //return articulos.getArrayList();
        return articuloDAO.readAll();
    }

    public Articulo getArticuloByCodigo(String codigo) {
        //return articulos.getArticuloByCodigo(codigo);
        return articuloDAO.read(codigo);
    }

    public boolean addArticulo(Articulo articulo){
        //return articulos.add(articulo);
        if(articuloDAO.read(articulo.getCodigo()) == null) {
            return articuloDAO.create(articulo);
        }
        return false;
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
