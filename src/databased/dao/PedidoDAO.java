package databased.dao;

import databased.interfaces.InterfaceDAO;
import databased.modelo.Articulo;
import databased.modelo.Pedido;

import java.util.List;

public class PedidoDAO implements InterfaceDAO<Pedido, Integer> {

    @Override
    public boolean create(Pedido pedido) {
        return false;
    }

    @Override
    public boolean update(Pedido pedido) {
        return false;
    }

    @Override
    public boolean delete(Pedido pedido) {
        return false;
    }

    @Override
    public Pedido read(Integer id) {
        return null;
    }

    @Override
    public List<Pedido> readAll() {
        return null;
    }
}
