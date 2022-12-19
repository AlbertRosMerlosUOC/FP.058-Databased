package databased.factory;

import databased.conexion.ConexionBD;
import databased.dao.ArticuloDAO;
import databased.dao.ClienteDAO;
import databased.dao.PedidoDAO;


public class FactoryDao {

   //TODO En el ejemplo de J2EE aqui crea el objeto conexion...?
    public ArticuloDAO getArticuloDAO(){
        return new ArticuloDAO();
    }

    public ClienteDAO getClienteDAO(){
        return new ClienteDAO();
    }

    public PedidoDAO getPedidoDAO(){
        return new PedidoDAO();
    }

}
