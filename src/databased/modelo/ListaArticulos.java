package databased.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaArticulos extends Lista<Articulo> {
// TO-BE-DONE
    public boolean compruebaArticulo(String Codigo){
        String codigoList;
        boolean encontrado = false;
        for(Articulo art: lista){
            codigoList = art.getCodigo();
            if(codigoList.equals(Codigo)){
                encontrado = true;
                break;
            }else{
                encontrado = false;
            }
        }
        return encontrado;
    }
}

