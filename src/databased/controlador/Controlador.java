package databased.controlador;

import databased.modelo.Articulo;
import databased.modelo.Cliente;
import databased.modelo.Datos;
import databased.vista.GestionOS;
import databased.vista.OnlineStore;

public class Controlador {
    private Datos model;
    private GestionOS view;

    public Controlador(Datos model, GestionOS view) {
        this.model = model;
        this.view = view;

        this.view.setController(this);
    }

    public void displayListaArticulos() {
        view.showArticulos(model.getArticulos());
    }

    public void addArticulo(Articulo articulo) {
        model.addArticulo(articulo);

    }

    public void getListaClientes() {
        view.showClientes(model.getClientes());
    }

    public void addCliente(Cliente cliente) {
        model.addCliente(cliente);
    }


}
