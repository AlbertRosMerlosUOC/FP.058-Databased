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

    public void addPedidoToModel(Pedido pedido){
        listaPedidos.add(pedido);
    }
    public void deletePedidoFromModel(int numeroPedido){
        //TODO
    }
}
