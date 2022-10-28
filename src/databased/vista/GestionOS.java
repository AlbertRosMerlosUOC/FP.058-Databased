package databased.vista;

import databased.controlador.Controlador;
import databased.modelo.*;

import java.util.List;
import java.util.Scanner;

public class GestionOS {
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in);

    public GestionOS() {
        controlador = new Controlador();
    }

    public void inicio() throws  EscrituraAccesoDatoException{
        boolean salir = false;
        char opt;
        do {
            printCabecera("Menu Principal");
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opt = printGetOpcion("Elige una opción (1,2,3 o 0): \"");
            switch (opt) {
                case '1':
                    printMenuArticulos();
                    break;
                case '2':
                    printMenuClientes();
                    break;
                case '3':
                    printMenuPedidos();
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }

    private void printMenuPedidos() {
        boolean salir = false;
        char opt;
        do {
            printCabecera("Gestion Pedidos");
            System.out.println("1. Añadir Pedido");
            System.out.println("2. Mostrar pedidos");
            System.out.println("3. Eliminar pedido");
            System.out.println("0. Salir");
            opt = printGetOpcion("Elige una opción (1,2,3 o 0): ");

            switch (opt) {
                case '1':
                    printAddPedido();
                    break;
                case '2':
                    printListPedidos();
                    break;
                case '3':
                    printDeletePedidos();
                    break;
                case '0':
                    salir = true;
            }
        }while (!salir);
    }

    private void printDeletePedidos() {
    }

    private void printListPedidos() {
        if(controlador.listPedidos().isEmpty()){
            System.out.println("No hay pedidos");
        }else{
            for(Pedido pd : controlador.listPedidos()) {
                System.out.println(pd);
            }
        }
    }

    private void printAddPedido() {
        int numPedido = controlador.listPedidos().size() + 1;
        //Pedir Cliente:
        System.out.print("Ingrese el email del cliente: ");
        String email = teclado.nextLine();
        Cliente cliente= controlador.getClienteByEmail(email);
        if(cliente == null){
            System.out.println("El cliente no exixte");
        }else{
            System.out.println();
        }
        //Pedir codigo articulo
        //Chek articulo
        //Pdir otros datos
        //insertar

    }

    public void printCabecera(String seccion){
        System.out.println("*********************");
        System.out.println("*  "+seccion+"  *");
        System.out.println("*********************");
    }
    char printGetOpcion(String texto) {
        String resp;
        System.out.println(texto);
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }
    /*
    Gestión Articulos
    */
    public void printMenuArticulos() throws EscrituraAccesoDatoException {
        boolean salir = false;
        char opt;
        do {
            printCabecera("Gestion Articulos");
            System.out.println("1. Añadir Artículo");
            System.out.println("2. Mostrar Artículos");
            System.out.println("0. Salir");
            opt = printGetOpcion("Elige una opción (1,2 o 0): ");

            switch (opt) {
                case '1':
                    printAddArticulo();
                    break;
                case '2':
                    //TBD
                    printListArticulos();
                    break;
                case '0':
                    salir = true;
            }
        }while (!salir);
    }
    public void printAddArticulo() throws EscrituraAccesoDatoException {
        System.out.print("Ingrese código alfanumérico del Artículo: ");
        String codigo = teclado.nextLine();

        System.out.print("Ingrese descripción del Artículo: ");
        String descripcion =  teclado.nextLine();
        System.out.print("Ingrese precio de venta del Artículo: ");
        double precioVenta = teclado.nextDouble();


        System.out.print("Ingrese gastos de envío del Artículo: ");
        double gastosEnvio = teclado.nextDouble();
        System.out.print("Ingrese tiempo de preparación del Artículo: ");
        int tiempoPreparacion = teclado.nextInt();
        teclado.nextLine();//nextInt omite el salto de linea. Se fuerza leer la nueva linea para evitar repetir la aparicion del menú

        boolean addOkArt = controlador.addArticulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
        if(addOkArt){
            System.out.println("Artículo " + codigo + " creado correctamente");
        }else{
            System.out.println("El código de artículo " + codigo + " es erróneo, ya existe");
        }
    }
    public void printListArticulos(){
        if(controlador.listArticulos().isEmpty()){
            System.out.println("No hay Articulos");
        }else{
            for(Articulo art : controlador.listArticulos()) {
                System.out.println(art);
            }
        }

    }
    /*
    Gestión Clientes
    */
    public void printMenuClientes() throws EscrituraAccesoDatoException {
        boolean salir = false;
        char opt;
        do {
            printCabecera("Gestion Clientes");
            System.out.println("1. Añadir Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Mostrar Clientes Standard");
            System.out.println("4. Mostrar Clientes Premium");
            System.out.println("0. Salir");
            opt = printGetOpcion("Elige una opción (1,2 o 0): ");

            switch (opt) {
                case '1':
                    printAddCliente();
                    break;
                case '2':
                    //TBD
                    printListClientesAll();
                    break;
                case '3':
                    //TBD
                    printListClientesStandard();
                    break;
                case '4':
                    //TBD
                    printListClientesPremium();
                    break;
                case '0':
                    salir= true;
            }
        }while (!salir);
    }
    public void printAddCliente() throws EscrituraAccesoDatoException {
        System.out.print("Ingrese el email del cliente: ");
        String email = teclado.nextLine();
        System.out.print("Ingrese el NIF del cliente: ");
        String nif =  teclado.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingrese el domicilio del cliente: ");
        String domicilio = teclado.nextLine();

        boolean tipoCliente = pritnGetTipoCliente();
        boolean addOkClt;
        if (tipoCliente){
            addOkClt = controlador.addClienteStandar(email, nif, nombre, domicilio);
        }else{
            addOkClt = controlador.addClientePremium(email, nif, nombre, domicilio);
        }

        if(addOkClt){
            System.out.println("Cliente " + email + " creado correctamente");
        }else{
            System.out.println("El email "+email+" ya existe");
        }
    }

    private boolean pritnGetTipoCliente() {
        do {
            char tipoCliente = printGetOpcion("Seleccione el tipo de cliente: [(1: standard),(2: premium)]");
            if (tipoCliente == '1') {
                return true;
            } else if (tipoCliente == '2') {
                return false;
            }
        }while(true);
    }

    public void printListClientesAll(){
        if(controlador.listClientes().isEmpty()){
            System.out.println("No hay Clientes");
        }else{
            for(Cliente clt : controlador.listClientes()) {
                System.out.println(clt);
            }
        }

    }
    public void printListClientesPremium(){
        if(controlador.listClientesPremium().isEmpty()){
            System.out.println("No hay Clientes Premium");
        }else{
            for(Cliente clt : controlador.listClientesPremium()) {
                System.out.println(clt);
            }
        }

    }
    public void printListClientesStandard(){
        if(controlador.listClientesStandard().isEmpty()){
            System.out.println("No hay Clientes Standard");
        }else{
            for(Cliente clt : controlador.listClientesStandard()) {
                System.out.println(clt);
            }
        }

    }

}

