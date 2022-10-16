package databased.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaArticulos{
    List<Articulo> listaArticulos;

    public ListaArticulos() {
        this.listaArticulos = new ArrayList<>();
    }

    public List<Articulo> getListaArticulos() {
        return listaArticulos;
    }


    public boolean addArticuloToModel(Articulo articulo){
        //TODO
        listaArticulos.add(articulo);
        return true;
    }

}
