package databased.dao;

import databased.interfaces.InterfaceDAO;
import databased.modelo.Articulo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO implements InterfaceDAO<Articulo, String> {

    @Override
    public Articulo create(Articulo articulo) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("onlineStoreJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(articulo);
        em.getTransaction().commit();
        em.close();
        return articulo;
    }

    @Override
    public boolean update(Articulo articulo) {
        //TODO
        return false;
    }

    @Override
    public boolean delete(String codigo) {
        //TODO
        return false;
    }

    @Override
    public Articulo read(String codigo) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("onlineStoreJPA");
        EntityManager em = emf.createEntityManager();
        Articulo articulo = em.find(Articulo.class, codigo);
        em.close();
        return articulo;
    }

    @Override
    public List<Articulo> readAll() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("onlineStoreJPA");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select a from Articulo a");
        ArrayList articulos =(ArrayList<Articulo>) query.getResultList();
        em.close();
        return articulos;

    }
}
