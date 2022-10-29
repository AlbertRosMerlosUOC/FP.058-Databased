package databased.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes extends Lista<Cliente> {
    public List<Cliente> getClientes(String tipoCliente) {
        List<Cliente> clientesFiltro = new ArrayList<>();
        for(Cliente clt : this.getArrayList()){
            if (clt.tipoCliente().equals(tipoCliente)) {
                if (tipoCliente.equals("ClientePremium")) {
                    ClientePremium clienteNuevo = (ClientePremium) clt.clona(clt);
                    clientesFiltro.add(clienteNuevo);
                } else {
                    ClienteStandard clienteNuevo = (ClienteStandard) clt.clona(clt);
                    clientesFiltro.add(clienteNuevo);
                }
            }
        }
        return clientesFiltro;
    }
    public Cliente getClienteByEmail(String email){
        for(Cliente cl : this.getArrayList()){
        //    if(cl.getNif().equals(email)){
              if(cl.getEmail().equals(email)){

                return cl;
            }
        }
        return null;
    }

}
