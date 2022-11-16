package databased.dao;

import databased.conexion.ConexionBD;
import databased.interfaces.InterfaceClienteDAO;
import databased.interfaces.InterfaceDAO;
import databased.modelo.Articulo;
import databased.modelo.Cliente;
import databased.modelo.ClientePremium;
import databased.modelo.ClienteStandard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements InterfaceClienteDAO<Cliente, String> {
    private static final String SQL_INSERT = "INSERT INTO Cliente (email, nif, nombre, domicilio, tipo_cliente) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Cliente SET email = ?, nif = ?, nombre = ?, domicilio = ?, tipo_cliente = ? WHERE email = ?";
    private static final String SQL_DELETE = "DELETE * FROM Cliente WHERE email = ?";
    private static final String SQL_READ = "SELECT * FROM Cliente WHERE email = ?";
    private static final String SQL_READ_BY_TIPO_CLIENTE = "SELECT * FROM Cliente WHERE tipo_cliente = ?";
    private static final String SQL_READALL = "SELECT * FROM Cliente;";

    private static final ConexionBD con = ConexionBD.getInstance();

    @Override
    public boolean create(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = con.getConexion().prepareStatement(SQL_INSERT);

            ps.setString(1, cliente.getEmail());
            ps.setString(2, cliente.getNif());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getDomicilio());
            ps.setString(5, cliente.tipoCliente());

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
    public boolean update(Cliente cliente) {
        return false;
    }

    @Override
    public boolean delete(Cliente cliente) {
        return false;
    }

    @Override
    public Cliente read(String email) {
        PreparedStatement ps;
        ResultSet res;
        Cliente cliente = null;
        try {
            ps = con.getConexion().prepareStatement(SQL_READ);
            ps.setString(1, email);
            res = ps.executeQuery();

            while (res.next()){
                if (res.getString("tipo_cliente").equals("ClientePremium")) {
                    cliente = new ClientePremium(res.getString("email"), res.getString("nif"), res.getString("nombre"), res.getString("domicilio"));
                } else {
                    cliente = new ClienteStandard(res.getString("email"), res.getString("nif"), res.getString("nombre"), res.getString("domicilio"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.closeConexion();
        }
        return cliente;
    }

    @Override
    public List<Cliente> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        try {
            ps = con.getConexion().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()){
                //(email, nif, nombre, domicilio, tipo_cliente), la cuota y el descuento se tratan como constantes en la clase ClientePremium)
                if (res.getString("tipo_cliente").equals("ClientePremium")) {
                    cliente = new ClientePremium(res.getString("email"), res.getString("nif"), res.getString("nombre"), res.getString("domicilio"));
                } else {
                    cliente = new ClienteStandard(res.getString("email"), res.getString("nif"), res.getString("nombre"), res.getString("domicilio"));
                }
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.closeConexion();
        }
        return clientes;
    }

    //TODO Es necesario en este caso crear interfaces concretas? o es suficiente implementar el método directamente?
    // Quitar la interfaz generica y crear interfaces para cada DAO?
    @Override
    public List<Cliente> readByTipoCliente(String tipoCliente) {
            PreparedStatement ps;
            ResultSet res;
            ArrayList<Cliente> clientes = new ArrayList<>();
            Cliente cliente = null;
            try {
                ps = con.getConexion().prepareStatement(SQL_READ_BY_TIPO_CLIENTE);
                ps.setString(1, tipoCliente);
                res = ps.executeQuery();

                while (res.next()){
                    //(email, nif, nombre, domicilio, tipo_cliente), la cuota y el descuento se tratan como constantes en la clase ClientePremium)
                    if (tipoCliente.equals("ClientePremium")) {
                        cliente = new ClientePremium(res.getString("email"), res.getString("nif"), res.getString("nombre"), res.getString("domicilio"));
                    } else {
                        cliente = new ClienteStandard(res.getString("email"), res.getString("nif"), res.getString("nombre"), res.getString("domicilio"));
                    }
                    clientes.add(cliente);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                con.closeConexion();
            }
            return clientes;
    }


}
