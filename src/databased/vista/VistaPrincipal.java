package databased.vista;

public class VistaPrincipal {
    private final VistaArticulos vistaArticulos;
    private final VistaClientes vistaClientes;
    private final VistaPedidos vistaPedidos;

    public VistaPrincipal(VistaArticulos vistaArticulos, VistaClientes vistaClientes, VistaPedidos vistaPedidos) {
        this.vistaArticulos = vistaArticulos;
        this.vistaClientes = vistaClientes;
        this.vistaPedidos = vistaPedidos;
    }
}
