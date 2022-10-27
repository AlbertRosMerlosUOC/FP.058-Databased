package databased.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaPedidos extends Lista<Pedido>{
    @Override
    public boolean add(Pedido pedido) {
        return false;
    }
}
