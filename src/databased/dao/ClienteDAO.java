package databased.dao;

import databased.interfaces.InterfaceDAO;
import databased.modelo.Articulo;
import databased.modelo.Cliente;

import java.util.List;

public class ClienteDAO implements InterfaceDAO<Cliente, Integer> {
    @Override
    public boolean create(Cliente cliente) {
        return false;
    }

    @Override
    public boolean update(Cliente cliente) {
        return false;
    }

    @Override
    public boolean delete(Cliente cliente) {
        return false;
    }

    @Override
    public Cliente read(Integer id) {
        return null;
    }

    @Override
    public List<Cliente> readAll() {
        return null;
    }
}
