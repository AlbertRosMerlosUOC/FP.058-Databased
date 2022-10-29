package databased.vista;

import databased.controlador.Controlador;
import databased.modelo.*; //TODO Eliminar
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
            printCabecera("Menú Principal");
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

    public void printCabecera(String seccion){
        System.out.println("*********************");
        System.out.println("*  " + seccion + "  *");
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

    /* Gestión Articulos */
    public void printMenuArticulos() throws EscrituraAccesoDatoException {
        boolean salir = false;
        char opt;
        do {
            printCabecera("Gestión Articulos");
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
        if (addOkArt) {
            System.out.println("Artículo " + codigo + " creado correctamente");
        } else {
            System.out.println("El código de artículo " + codigo + " es erróneo, ya existe");
        }
    }

    public void printListArticulos() {
        System.out.println(controlador.printListaArticulos());
    }

    /* Gestión Clientes */
    public void printMenuClientes() {
        boolean salir = false;
        char opt;
        do {
            printCabecera("Gestión Clientes");
            System.out.println("1. Añadir Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Mostrar Clientes Standard");
            System.out.println("4. Mostrar Clientes Premium");
            System.out.println("0. Salir");
            opt = printGetOpcion("Elige una opción (1,2,3,4 o 0): ");

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

    public void printAddCliente() {
        System.out.print("Ingrese el email del cliente: ");
        String email = teclado.nextLine();
        System.out.print("Ingrese el NIF del cliente: ");
        String nif =  teclado.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingrese el domicilio del cliente: ");
        String domicilio = teclado.nextLine();

        boolean tipoCliente = printGetTipoCliente();
        boolean addOkClt;
        if (tipoCliente){
            addOkClt = controlador.addClienteStandard(email, nif, nombre, domicilio);
        }else{
            addOkClt = controlador.addClientePremium(email, nif, nombre, domicilio);
        }

        if(addOkClt){
            System.out.println("Cliente " + email + " creado correctamente");
        }else{
            System.out.println("El email " + email + " ya existe");
        }
    }

    public void printAddCliente(String email) {
        System.out.print("Ingrese el NIF del nuevo cliente: ");
        String nif =  teclado.nextLine();
        System.out.print("Ingrese el nombre del nuevo cliente: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingrese el domicilio del nuevo cliente: ");
        String domicilio = teclado.nextLine();

        boolean tipoCliente = printGetTipoCliente();
        boolean addOkClt;
        if (tipoCliente) {
            addOkClt = controlador.addClienteStandard(email, nif, nombre, domicilio);
        } else {
            addOkClt = controlador.addClientePremium(email, nif, nombre, domicilio);
        }

        if (addOkClt) {
            System.out.println("Cliente " + email + " creado correctamente");
        } else{
            System.out.println("El email " + email + " ya existe");
        }
    }

    private boolean printGetTipoCliente() {
        do {
            char tipoCliente = printGetOpcion("Seleccione el tipo de cliente: [(1: Standard),(2: Premium)]");
            if (tipoCliente == '1') {
                return true;
            } else if (tipoCliente == '2') {
                return false;
            }
        }while(true);
    }

    public void printListClientesAll(){
        // TODO Eliminar el uso de la clase Cliente del modelo
        if(controlador.listClientes().isEmpty()){
            System.out.println("No hay Clientes");
        }else{
            for(Cliente clt : controlador.listClientes()) {
                System.out.println(clt);
            }
        }

    }
    public void printListClientesPremium() {
        // TODO Eliminar el uso de la clase Cliente del modelo
        if(controlador.listClientesPremium().isEmpty()){
            System.out.println("No hay Clientes Premium");
        }else{
            for(Cliente clt : controlador.listClientesPremium()) {
                System.out.println(clt);
            }
        }
    }

    public void printListClientesStandard() {
        // TODO Eliminar el uso de la clase Cliente del modelo
        if(controlador.listClientesStandard().isEmpty()){
            System.out.println("No hay Clientes Standard");
        }else{
            for(Cliente clt : controlador.listClientesStandard()) {
                System.out.println(clt);
            }
        }
    }

    /* Gestión Pedidos */
    private void printMenuPedidos() throws EscrituraAccesoDatoException {
        boolean salir = false;
        char opt;
        do {
            printCabecera("Gestión Pedidos");
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
        // TODO
    }

    private void printListPedidos() {
        // TODO Eliminar el uso de la clase Pedido del modelo
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
        System.out.print("Ingrese el email del cliente: ");
        String email = teclado.nextLine();
        boolean existe = controlador.existCliente(email);
        if (!(existe)) {
            System.out.println("El cliente informado no existe. Para poder continuar deberá crear un nuevo cliente.");
            printAddCliente(email);
        }
        // TODO Pedir codigo articulo
        // TODO Chek articulo
        // TODO Pedir otros datos
        // TODO insertar

    }
}

