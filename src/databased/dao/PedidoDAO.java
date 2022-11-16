package databased.dao;

import databased.conexion.ConexionBD;
import databased.interfaces.InterfaceDAO;
import databased.modelo.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements InterfaceDAO<Pedido, Integer> {
    private static final String SQL_INSERT = "INSERT INTO Pedido () VALUES (?, ?, ?, ?, ?)";
    //INSERT INTO `online_store`.`Pedido` (`email`, `codigo`, `cantidad`, `local_date_time`) VALUES ('pepe@gmail.com', 'A1', '2', '2022-02-02 22:22:22');
    private static final String SQL_UPDATE = "UPDATE Pedido SET x=? WHERE  num_pedido = ?";
    private static final String SQL_DELETE = "DELETE * FROM Pedido WHERE num_pedido = ?";
    private static final String SQL_READ = "SELECT * FROM Pedido WHERE num_pedido = ?";
    private static final String SQL_READALL = "SELECT p.num_pedido , c.*, a.*, p.cantidad, p.local_date_time fecha_pedido\n" +
                                                "FROM Pedido AS p\n" +
                                                "INNER JOIN Cliente AS c\n" +
                                                "    ON p.email = c.email\n" +
                                                "INNER JOIN Articulo AS a\n" +
                                                "    ON p.codigo = a.codigo";

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
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = null;
        Cliente cliente = null;
        Articulo articulo = null;
        try {
            ps = con.getConexion().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()){
                if (res.getString("tipo_cliente").equals("ClientePremium")) {
                    cliente = new ClientePremium(res.getString("email"), res.getString("nif"), res.getString("nombre"), res.getString("domicilio"));
                } else {
                    cliente = new ClienteStandard(res.getString("email"), res.getString("nif"), res.getString("nombre"), res.getString("domicilio"));
                }
                articulo = new Articulo(res.getString("codigo"), res.getString("descripcion"), res.getDouble("precio_venta"), res.getDouble("gastos_envio"), res.getInt("tiempo_preparacion"));
                pedidos.add(new Pedido(res.getInt("num_pedido"), cliente, articulo,res.getInt("cantidad") , res.getTimestamp("fecha_pedido").toLocalDateTime()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.closeConexion();
        }
        return pedidos;
    }
}
