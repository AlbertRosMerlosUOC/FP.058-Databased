package databased.controlador;

import databased.modelo.*;
import databased.vista.GestionOS;
import databased.vista.OnlineStore;

public class Controlador {
    private Datos datos;
    public Controlador() {
        datos = new Datos ();
    }
    // TO-BE-DONE

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public int addArticulo (String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacion) throws EscrituraAccesoDatoException, EscrituraAccesoDatoException {
        //0 = OK; 1 = error al insertar; 2 = el codigo de articulo ya existe
        int logAdd = 0;
        boolean okAddArt = false;
        Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);

        ListaArticulos listaArticulos = datos.getListaArticulos();
        boolean encontrado =  listaArticulos.compruebaArticulo(codigo);
        if(encontrado == false){
            okAddArt =  listaArticulos.add(articulo);
            if(okAddArt == true){
                logAdd = 0;
            }else{
                logAdd = 1;
            }
        }else{
            logAdd = 2;
        }
        return logAdd;
    }
    public void listArticulos(){
        ListaArticulos listaArticulos = datos.getListaArticulos();
        listaArticulos.list();

    }
}