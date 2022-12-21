package databased.dao;

import databased.interfaces.InterfacePedidoDAO;
import databased.modelo.*;
import jakarta.persistence.*;

import java.util.List;

public class PedidoDAO implements InterfacePedidoDAO<Pedido, Integer> {

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
    public Pedido delete(Integer numPedido) {
        EntityManager em = emf.createEntityManager();
        Pedido pedido = em.find(Pedido.class, numPedido);
        if(pedido !=null){
            em.remove(pedido);
        }
        em.close();
        return pedido;
    }

    @Override
    public Pedido read(Integer numPedido) {
        EntityManager em = emf.createEntityManager();
        Pedido pedido = em.find(Pedido.class, numPedido);
        em.close();
        return pedido;
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
        EntityManager em = emf.createEntityManager();
        int result;
        // Create call stored procedure
        em.getTransaction().begin();
        try{
            StoredProcedureQuery cdsp = em.createStoredProcedureQuery("control_delete_pedido");
            // set parameter v_num_pedido INT, OUT v_control INT
            cdsp.registerStoredProcedureParameter("v_num_pedido", Integer.class, ParameterMode.IN);
            cdsp.registerStoredProcedureParameter("v_control", Integer.class, ParameterMode.OUT);
            cdsp.setParameter("v_num_pedido", numPedido);
            // execute SP
            cdsp.execute();
            // get result
            result = (int) cdsp.getOutputParameterValue("v_control");
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
            throw new DAOException(e);
        }finally {
            em.close();
        }

        return result;      // Posibles resultados:
                            //      1: Es posible borrar el pedido
                            //      0: No es posible borrar el pedido, ya que se ha superado la fecha máxima para hacerlo
                            //     -1: No se ha encontrado el pedido a borrar
    }
}
