package databased.factory;

import databased.conexion.ConexionBD;
import databased.dao.ArticuloDAO;
import databased.dao.ClienteDAO;
import databased.dao.PedidoDAO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class FactoryDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("onlineStoreJPA");;

    public ArticuloDAO getArticuloDAO(){
        return new ArticuloDAO(emf);
    }

    public ClienteDAO getClienteDAO(){
        return new ClienteDAO(emf);
    }

    public PedidoDAO getPedidoDAO(){
        return new PedidoDAO();
    }

}
