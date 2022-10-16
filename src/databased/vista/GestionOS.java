package databased.vista;

import databased.controlador.Controlador;
import databased.modelo.*;

import java.util.List;
import java.util.Scanner;

public class GestionOS {
    private Controlador controller;

    public void setController(Controlador controller) {
        this.controller = controller;
    }
    public void run() {
        // Create object of Scanner class so that we can take input from command-line
        Scanner myScanner = new Scanner(System.in);

        String inputLine;
        showAddCientes();
        System.out.print("Intro to show");
        while (myScanner.hasNextLine()) {
            // Scan next line from command-prompt
            inputLine = myScanner.nextLine();
            showListaCientes();
        }
    }

    public void showMenu() {

    }

    public void showListaArticulos(){
        this.controller.displayListaArticulos();
    }
    public void showAddArticulo(){
        this.controller.addArticulo(new Articulo("1234", "Verduritas...", 23.7f, 3.4f, 20));
    }
    public void showListaCientes(){
        this.controller.getListaClientes();
    }
    public void showListaCientesEstandard(){

    }
    public void showListaCientesPremium(){

    }
    public void showAddCientes(){
        System.out.println("Adding clients...");
        this.controller.addCliente(new ClienteStandard("eeee@sdf.com", "123456", "Toni", "asdfsdf"));
        this.controller.addCliente(new ClienteStandard("", "1", "Mierda", "Water"));
        this.controller.addCliente(new ClientePremium("er", "sf", "Luisa", ""));
    }
    public void showPedidosPendientes(){

    }
    public void showPedidosPendientesEnvio(String emailCliente){

    }
    public void showPedidosEnviados(){

    }
    public void showPedidosEnviados(String emailCliente){

    }




    public void showArticulos(List<Articulo> listaArticulos) {
        for(Articulo articulo : listaArticulos){
            System.out.println(articulo);
        }
    }
    public void showClientes(List<Cliente> listaClientes) {
        for(Cliente cliente : listaClientes){
            System.out.println(cliente);
        }
    }
    public void showPedidos(List<Pedido> listaPedidos) {
        for(Pedido pedido : listaPedidos){
            System.out.println(pedido);
        }
    }

}
