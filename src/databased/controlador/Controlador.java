package databased.controlador;

import databased.modelo.*;
import databased.modelo.Datos;

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

    public boolean addArticulo (String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacion) throws EscrituraAccesoDatoException {
        Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);

        ListaArticulos listaArticulos = datos.getListaArticulos();
        boolean okAddArt =  listaArticulos.add(articulo);
        return okAddArt;
    }
    public void listArticulos(){
        ListaArticulos listaArticulos = datos.getListaArticulos();
        listaArticulos.list();
    }
}

