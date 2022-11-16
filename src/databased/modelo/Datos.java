package databased.modelo;

import databased.dao.ArticuloDAO;
import databased.dao.ClienteDAO;
import databased.dao.PedidoDAO;
import databased.factory.FactoryDao;

import java.util.List;

/*
TODO MAntenemos esta clase como requisito del P1: el controlador solo llamará a los métodos de esta clase.
 Y nos sirve para no tener que modificar los métodos del controlador
*/
public class Datos {
    private final ListaPedidos pedidos;
    FactoryDao mysqlDAO;
    private final ArticuloDAO articuloDAO;
    private final ClienteDAO clienteDAO;
    private final PedidoDAO pedidoDAO;
    public Datos() {
        this.mysqlDAO = new FactoryDao();

        this.pedidos = new ListaPedidos();

        this.articuloDAO = mysqlDAO.getArticuloDAO();
        this.clienteDAO = mysqlDAO.getClienteDAO();
        this.pedidoDAO = mysqlDAO.getPedidoDAO();
    }

    public List<Cliente> getClientes() {
        //return clientes.getArrayList();
        return clienteDAO.readAll();
    }

    public List<Cliente> getClientes(String tipoCliente) {
        //return clientes.getClientes(tipoCliente);
        return clienteDAO.readByTipoCliente(tipoCliente);
    }

    public Cliente getClienteByEmail(String email) {
        //return clientes.getClienteByEmail(email);
        return clienteDAO.read(email);
    }

    public boolean addCliente(Cliente cliente) {
        if(clienteDAO.read(cliente.getEmail()) == null){
           return  clienteDAO.create(cliente);
        }
        return false;
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
        //TODO verificar si existe el articulo antes de indsertar...aqui, en articuloDAO o en el controlador
        if(articuloDAO.read(articulo.getCodigo()) == null) {
            return articuloDAO.create(articulo);
        }
        return false;
    }

    public List<Pedido> getPedidos() {
        //return pedidos.getArrayList();
        return pedidoDAO.readAll();
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
