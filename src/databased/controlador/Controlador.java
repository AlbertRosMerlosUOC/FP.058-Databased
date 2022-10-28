package databased.controlador;

import databased.modelo.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private Datos datos;
    //vista
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

    public List<Articulo> listArticulos(){
        return datos.getArticulos();
    }
    public boolean addArticulo (String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacion) throws EscrituraAccesoDatoException, EscrituraAccesoDatoException {
        //0 = OK; 1 = error al insertar; 2 = el codigo de articulo ya existe
        Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
        return datos.addArticulo(articulo);
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
    public Cliente getClienteByEmail(String email){
        return datos.getClienteByEmail(email);
    }
    public List<Pedido> listPedidos() { return datos.getPedidos();}
    public boolean addPedido(int numPedido, Cliente cliente, Articulo articulo, int cantidad, LocalDateTime fechaPedido){
        Pedido pedido = new Pedido(numPedido, cliente, articulo, cantidad, fechaPedido);
        return datos.addPedido(pedido);
    };
    public boolean deletePedido(int idPedido){
        return deletePedido(idPedido);
    }
}