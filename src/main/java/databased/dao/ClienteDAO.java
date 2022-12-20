package databased.dao;

import databased.interfaces.InterfaceClienteDAO;
import databased.modelo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import java.util.List;

public class ClienteDAO implements InterfaceClienteDAO<Cliente, String> {

    private EntityManagerFactory emf;

    public ClienteDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Cliente create(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new DAOException(e);
        } finally {
            em.close();
        }
        return cliente;
    }

    @Override
    public boolean update(Cliente cliente) {
        return false;
    }

    @Override
    public boolean delete(String email) {
        return false;
    }

    @Override
    public Cliente read(String email) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, email);
        em.close();
        return cliente;
    }

    @Override
    public List<Cliente> readAll() {

        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select c from Cliente c ");
        List<Cliente> clientes = query.getResultList();
        em.close();
        return clientes;
    }

    @Override
    public List<Cliente> readByTipoCliente(String tipoCliente) {

        //TODO con named parameters no me ha funcionado...?
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE TYPE(c) = '"+tipoCliente+"'");
        List<Cliente> clientes = query.getResultList();
        em.close();
            return clientes;
    }
}
