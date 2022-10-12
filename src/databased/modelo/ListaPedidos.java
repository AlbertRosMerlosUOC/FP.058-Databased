package src.databased.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaPedidos {
    List<Pedido> listaPedidos;

    public ListaPedidos() {
        this.listaPedidos = new ArrayList<>();
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public boolean addPedidoToModel(Pedido pedido){
        //TODO
        listaPedidos.add(pedido);
        return true;
    }
    public boolean deletePedidoFromModel(int numeroPedido){
        //TODO
        return true;
    }
}
