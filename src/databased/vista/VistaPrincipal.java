package src.databased.vista;

public class VistaPrincipal {
    private VistaArticulos vistaArticulos;
    private VistaClientes vistaClientes;
    private VistaPedidos vistaPedidos;

    public VistaPrincipal(VistaArticulos vistaArticulos, VistaClientes vistaClientes, VistaPedidos vistaPedidos) {
        this.vistaArticulos = vistaArticulos;
        this.vistaClientes = vistaClientes;
        this.vistaPedidos = vistaPedidos;
    }
}
