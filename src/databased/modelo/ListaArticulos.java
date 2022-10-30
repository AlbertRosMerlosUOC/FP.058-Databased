package databased.modelo;

public class ListaArticulos extends Lista<Articulo> {

    public Articulo getArticuloByCodigo(String codigo){
        for(Articulo ar : this.getArrayList()){
            if(ar.getCodigo().equals(codigo)) {
                return ar;
            }
        }
        return null;
    }
}
