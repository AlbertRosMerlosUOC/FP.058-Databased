package databased.interfaces;

import databased.modelo.Cliente;

import java.util.List;

public interface InterfaceClienteDAO<T, K> extends InterfaceDAO<T, K>{
    public List<T> readByTipoCliente(String type);
}
