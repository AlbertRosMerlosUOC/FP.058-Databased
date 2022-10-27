package databased.controlador;

import databased.modelo.*;

import java.util.ArrayList;
import java.util.List;

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

    public boolean addArticulo (String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacion) throws EscrituraAccesoDatoException, EscrituraAccesoDatoException {
        //0 = OK; 1 = error al insertar; 2 = el codigo de articulo ya existe
        Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
        return datos.addArticulo(articulo);
    }
    public List<Articulo> listArticulos(){
        return datos.getArticulos();
    }

    public List<Cliente> listClientesStandard() {
        return datos.getClientes("ClienteStandard");
    }
    public List<Cliente> listClientesPremium() {
        return datos.getClientes("ClientePremium");
    }
    public List<Cliente> listClientes() {
        return datos.getClientes();
    }

    public boolean addClienteStandar(String email, String nif, String nombre, String domicilio) {
        Cliente cliente = new ClienteStandard(email, nif, nombre, domicilio);
        return  datos.addCliente(cliente);
    }
    public boolean addClientePremium(String email, String nif, String nombre, String domicilio) {
        Cliente cliente = new ClientePremium(email, nif, nombre, domicilio);
        return  datos.addCliente(cliente);
    }
}