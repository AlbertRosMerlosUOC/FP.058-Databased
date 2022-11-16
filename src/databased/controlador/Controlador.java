package databased.controlador;

import databased.modelo.*;
import databased.vista.*;

import java.time.LocalDateTime;


public class Controlador {
    private Datos datos;
    private final ColoresConsola colores;
    public Controlador() {
        datos = new Datos ();
        colores = new ColoresConsola();
    }

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public String listArticulos(){
        String retorno = "";
        if(datos.getArticulos().isEmpty()){
            retorno = colores.consola("No hay Artículos", 42);
        }else{
            for(Articulo art : datos.getArticulos()) {
                retorno += art.toString();
            }
        }
        return retorno;

    }
    public boolean addArticulo (String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacion){
        //0 = OK; 1 = error al insertar; 2 = el codigo de articulo ya existe
        Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
        return datos.addArticulo(articulo);
    }
    public Articulo getArticuloByCodigo(String codigo){
        return datos.getArticuloByCodigo(codigo);
    }
    public boolean existArticulo(String codigo){
        return datos.getArticuloByCodigo(codigo) != null;
    }

    public String listClientes() {
        String retorno ="";
        if(datos.getClientes().isEmpty()){
            retorno = colores.consola("No hay Clientes", 42);
        }else{
            for(Cliente clt : datos.getClientes()) {
                retorno += clt.toString();
            }
        }
        return retorno;
    }
    public String listClientesStandard() {
        String retorno ="";
        if(datos.getClientes("ClienteStandard").isEmpty()){
            retorno = colores.consola("No hay Clientes Standard", 42);
        }else{
            for(Cliente clt : datos.getClientes("ClienteStandard")) {
                retorno += clt.toString();
            }
        }
        return retorno;
    }
    public String listClientesPremium() {
        String retorno ="";
        if(datos.getClientes("ClientePremium").isEmpty()){
            retorno = colores.consola("No hay Clientes Premium", 42);
        }else{
            for(Cliente clt : datos.getClientes("ClientePremium")) {
                retorno += clt.toString();
            }
        }
        return retorno;
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


    public String listPedidos() {
        String retorno ="";
        if(datos.getPedidos().isEmpty()){
            retorno = colores.consola("No hay Pedidos", 42);
        }else{
            for(Pedido pd : datos.getPedidos()) {
                retorno += pd.toString();
            }
        }
        return retorno;
    }
    public boolean addPedido(Cliente cliente, Articulo articulo, int cantidad, LocalDateTime fechaPedido){
        int numPedido = datos.getPedidos().size() + 1;
        Pedido pedido = new Pedido(numPedido, cliente, articulo, cantidad, fechaPedido);
        return datos.addPedido(pedido);
    }


    public String deletePedido(int numPedido){
        //0 no existe, 1 enviado, 2 eliminado
        int res = datos.deletePedido(numPedido);
        switch (res) {
            case 0:
                return colores.consola("No se ha encontrado ningún pedido con el número indicado", 42);
            case 1:
                return colores.consola("Pedido eliminado correctamente", 43);
            case 2:
                return colores.consola("El pedido ya ha sido enviado y no se ha podido eliminar", 42);
            default:
                return colores.consola("Error eliminando el pedido", 42);

        }
    }

}