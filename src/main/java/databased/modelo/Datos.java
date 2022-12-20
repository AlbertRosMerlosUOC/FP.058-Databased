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
    FactoryDao mysqlDAO;
    private final ArticuloDAO articuloDAO;
    private final ClienteDAO clienteDAO;
    private final PedidoDAO pedidoDAO;
    public Datos() {
        this.mysqlDAO = new FactoryDao();

        this.articuloDAO = mysqlDAO.getArticuloDAO();
        this.clienteDAO = mysqlDAO.getClienteDAO();
        this.pedidoDAO = mysqlDAO.getPedidoDAO();
    }

    public List<Cliente> getClientes() {
        return clienteDAO.readAll();
    }

    public List<Cliente> getClientes(String tipoCliente) {
        return clienteDAO.readByTipoCliente(tipoCliente);
    }

    public Cliente getClienteByEmail(String email) {
        return clienteDAO.read(email);
    }

    public boolean addCliente(Cliente cliente) {
        if(clienteDAO.read(cliente.getEmail()) == null){
           return  clienteDAO.create(cliente) != null;
        }
        return false;
    }

    public List<Articulo> getArticulos() {
        return articuloDAO.readAll();
    }

    public Articulo getArticuloByCodigo(String codigo) {
        return articuloDAO.read(codigo);
    }

    public boolean addArticulo(Articulo articulo){

        if(articuloDAO.read(articulo.getCodigo()) == null) {
            return (articuloDAO.create(articulo) != null);
        }
        return false;
    }

    public List<Pedido> getPedidos() {
        return pedidoDAO.readAll();
    }

    public Pedido getPedidoById(int idPedido) {
       return pedidoDAO.read(idPedido);
    }

    public boolean addPedido(Pedido pedido) {
        //TODO La clave primaria es un INT auto incremetable, por lo que no hace falta verificar si el pedido exosite antes de crearlo
        return pedidoDAO.create(pedido) != null;
    }

    public int deletePedido(int numPedido) {
        /* TODO Albert: Comento esta parte del código original por si se quiere usar en lugar del procedimiento.
        Pedido pedido = pedidoDAO.read(numPedido);
        if (pedido != null) {
            if (!(pedido.pedidoEnviado())) {
                if (pedidoDAO.delete(numPedido)) {
                    return 1;
                }
                return 3;
            }
            return 2;
        }
        return 0;*/
        return pedidoDAO.controlDelete(numPedido);
    }
}
