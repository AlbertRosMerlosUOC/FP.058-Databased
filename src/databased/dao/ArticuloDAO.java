package databased.dao;

import databased.conexion.ConexionBD;
import databased.interfaces.InterfaceDAO;
import databased.modelo.Articulo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ArticuloDAO implements InterfaceDAO<Articulo, String> {

    private static final String SQL_INSERT = "INSERT INTO Articulo (codigo, descripcion, precio_venta, gastos_envio, tiempo_preparacion) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Articulo SET descripcion = ?, precio_venta = ?, gastos_envio = ?, tiempo_preparacion = ? WHERE codigo = ?";
    private static final String SQL_DELETE = "DELETE * FROM Articulo WHERE codigo = ?";
    private static final String SQL_READ = "SELECT * FROM Articulo WHERE codigo = ?";
    private static final String SQL_READALL = "SELECT * FROM Articulo;";

    private static final ConexionBD con = ConexionBD.getInstance();

    @Override
    public boolean create(Articulo articulo) {

            PreparedStatement ps = null;
            try {
                ps = con.getConexion().prepareStatement(SQL_INSERT);

                ps.setString(1, articulo.getCodigo());
                ps.setString(2, articulo.getDescripcion());
                ps.setDouble(3, articulo.getGastosEnvio());
                ps.setDouble(4, articulo.getGastosEnvio());
                ps.setInt(5, articulo.getTiempoPreparacion());

                if (ps.executeUpdate() > 0) {
                    return true;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                con.closeConexion();
            }

        return false;
    }

    @Override
    public boolean update(Articulo articulo) {
        //TODO
        return false;
    }

    @Override
    public boolean delete(Articulo articulo) {
        //TODO
        return false;
    }

    @Override
    public Articulo read(String id) {
        //TODO
        PreparedStatement ps;
        ResultSet res;
        Articulo articulo = null;

        try {
            ps = con.getConexion().prepareStatement(SQL_READ);
            ps.setString(1, id);
            res = ps.executeQuery();

            while (res.next()){
                articulo = new Articulo(res.getString(1), res.getString(2), res.getDouble(3), res.getDouble(4), res.getInt(5));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            con.closeConexion();
        }
        return articulo;
    }

    @Override
    public List<Articulo> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Articulo> articulos = new ArrayList<>();

        try {
            ps = con.getConexion().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()){
                articulos.add(new Articulo(res.getString(1), res.getString(2), res.getDouble(3), res.getDouble(4), res.getInt(5)));
            }
        } catch (SQLException e) {
        throw new RuntimeException(e);
        } finally {
            con.closeConexion();
        }
        return articulos;
    }
}
