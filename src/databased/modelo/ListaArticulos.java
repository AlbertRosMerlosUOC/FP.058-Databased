package src.databased.modelo;

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


    public void addArticuloToModel(Articulo articulo){
        listaArticulos.add(articulo);
    }
    public void deleteArticuloFromModel(String codigoArticulo){
        //TODO
    }
}
