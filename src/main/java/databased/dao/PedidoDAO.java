package databased.dao;

import databased.conexion.ConexionBD;
import databased.interfaces.InterfacePedidoDAO;
import databased.modelo.*;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements InterfacePedidoDAO<Pedido, Integer> {
    private static final String SQL_INSERT = "INSERT INTO Pedido (email, codigo, cantidad, local_date_time) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "";
    private static final String SQL_DELETE = "DELETE FROM Pedido WHERE num_pedido = ?";
    private static final String SQL_READ =  "{call get_product_by_num_pedido(?)}";
    private static final String SQL_READALL = "{call get_all_products_detail()}";
    private static final String SQL_CONTROL = "{call control_delete_pedido(?, ?)}";

    private static final ConexionBD con = ConexionBD.getInstance();
    private EntityManagerFactory emf;


    public PedidoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Pedido create(Pedido pedido) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(pedido);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new DAOException(e);
        }finally {
            em.close();
        }
        return pedido;
    }

    @Override
    public boolean update(Pedido pedido) {
        return false;
    }

    @Override
    public boolean delete(Integer numPedido) {
        PreparedStatement ps = null;
        try {
            ps = con.getConexion().prepareStatement(SQL_DELETE);
            ps.setInt(1, numPedido);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.closeConexion();
        }
        return false;
    }

    @Override
    public Pedido read(Integer id) {

        return null;
    }

    @Override
    public List<Pedido> readAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select p from Pedido p");
        List pedidos = query.getResultList();
        em.close();
        return pedidos;
    }

    @Override
    public int controlDelete(int numPedido) {
        CallableStatement cs = null;
        int result = -2;
        try {
            cs = con.getConexion().prepareCall(SQL_CONTROL);
            cs.setInt(1, numPedido);
            cs.registerOutParameter(2, Types.INTEGER);

            cs.executeUpdate();
            result = cs.getInt(2);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.closeConexion();
        }
        return result;      // Posibles resultados:
                            //      1: Es posible borrar el pedido
                            //      0: No es posible borrar el pedido, ya que se ha superado la fecha máxima para hacerlo
                            //     -1: No se ha encontrado el pedido a borrar
                            //     -2: Si algo falla en la procedure / método
    }
}
