package databased.modelo;

public class ListaPedidos extends Lista<Pedido> {

    public Pedido getPedidoById(int idPedido){
        for(Pedido pe : this.getArrayList()){
            if(pe.getNumPedido() == idPedido){
                return pe;
            }
        }
        return null;
    }

}
