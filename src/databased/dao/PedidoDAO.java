package databased.dao;

import databased.conexion.ConexionBD;
import databased.interfaces.InterfaceDAO;
import databased.modelo.Articulo;
import databased.modelo.Pedido;

import java.util.List;

public class PedidoDAO implements InterfaceDAO<Pedido, Integer> {
    private static final String SQL_INSERT = "INSERT INTO Pedido () VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Pedido SET x=? WHERE  num_pedido = ?";
    private static final String SQL_DELETE = "DELETE * FROM Pedido WHERE num_pedido = ?";
    private static final String SQL_READ = "SELECT * FROM Pedido WHERE num_pedido = ?";
    private static final String SQL_READALL = "SELECT * FROM num_pedido";

    private static final ConexionBD con = ConexionBD.getInstance();
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
