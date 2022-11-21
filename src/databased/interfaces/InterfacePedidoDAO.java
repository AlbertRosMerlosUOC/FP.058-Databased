package databased.interfaces;

public interface InterfacePedidoDAO<T, K> extends InterfaceDAO<T, K>{
    public int controlDelete(int numPedido);
}
