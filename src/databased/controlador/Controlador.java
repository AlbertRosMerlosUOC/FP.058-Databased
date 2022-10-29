package databased.controlador;

import databased.modelo.*;
import databased.vista.*;

import java.time.LocalDateTime;
import java.util.List;

public class Controlador {
    private Datos datos;
    private ColoresConsola colores;
    public Controlador() {
        datos = new Datos ();
        colores = new ColoresConsola();
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

    public boolean addArticulo (String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacion) throws EscrituraAccesoDatoException {
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

    public boolean addClienteStandard(String email, String nif, String nombre, String domicilio) {
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

    public boolean existCliente(String email){
        return datos.getClienteByEmail(email) != null;
    }

    public List<Pedido> listPedidos() { return datos.getPedidos();}

    public boolean addPedido(int numPedido, Cliente cliente, Articulo articulo, int cantidad, LocalDateTime fechaPedido){
        Pedido pedido = new Pedido(numPedido, cliente, articulo, cantidad, fechaPedido);
        return datos.addPedido(pedido);
    }

    public boolean deletePedido(int idPedido){
        return deletePedido(idPedido);
    }

    public String printListaArticulos() {
        String retorno = "";
        if(this.listArticulos().isEmpty()){
            retorno = colores.consola("No hay Artículos", 42);
        }else{
            for(Articulo art : this.listArticulos()) {
                retorno += art.toString();
            }
        }
        return retorno;
    }
    public String printListaClientesAll(){
        String retorno ="";

        if(this.listClientes().isEmpty()){

        }else{
            for(Cliente clt : this.listClientes()) {
                retorno = clt.toString();
            }
        }
        return retorno;
    }

    public String printListaClientesPremium(){
        String retorno ="";
        if(this.listClientesPremium().isEmpty()){
            retorno = "No hay Clientes Premium";
        }else{
            for(Cliente clt : this.listClientesPremium()) {
                retorno = clt.toString();
            }
        }
        return retorno;
    }
    public String printListaClientesStandard(){
        String retorno ="";
        if(this.listClientesStandard().isEmpty()){
            retorno = "No hay Clientes Standard";
        }else{
            for(Cliente clt : this.listClientesStandard()) {
                retorno = clt.toString();
            }
        }
        return retorno;
    }

    public String printListaPedidos() {
        String retorno ="";
        if(this.listPedidos().isEmpty()){
            retorno = "No hay pedidos";
        }else{
            for(Pedido pd : this.listPedidos()) {
                retorno = pd.toString();
            }
        }
        return retorno;
    }

}