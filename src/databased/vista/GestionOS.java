package databased.vista;

import databased.controlador.Controlador;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class GestionOS {
    private Controlador controlador;
    private ColoresConsola colores;
    private String tabulador;

    Scanner teclado = new Scanner(System.in);

    public GestionOS() {
        controlador = new Controlador();
        colores = new ColoresConsola();
        tabulador = "   ";
    }

    public void inicio() throws  EscrituraAccesoDatoException{
        boolean salir = false;
        char opt;
        do {
            printCabecera("Menú Principal");
            System.out.println(tabulador + colores.consola("1", 45) + ". Gestión Artículos");
            System.out.println(tabulador + colores.consola("2", 45) + ". Gestión Clientes");
            System.out.println(tabulador + colores.consola("3", 45) + ". Gestión Pedidos");
            System.out.println(tabulador + colores.consola("0", 42) + ". Salir");
            opt = printGetOpcion("Elige una opción (1,2,3 o 0): ");
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
        System.out.println("\n" +
                           colores.consola("*********************", 45) + "\n" +
                           colores.consola("*  ", 45) + colores.consola(seccion, 57, 45) + colores.consola("  *", 45) + "\n" +
                           colores.consola("*********************", 45));
    }

    char printGetOpcion(String texto) {
        String resp;
        System.out.print(texto);
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
            System.out.println(tabulador + colores.consola("1", 45) + ". Añadir Artículo");
            System.out.println(tabulador + colores.consola("2", 45) + ". Mostrar Artículos");
            System.out.println(tabulador + colores.consola("0", 42) + ". Volver");
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
            System.out.println(tabulador + colores.consola("1", 45) + ". Añadir Cliente");
            System.out.println(tabulador + colores.consola("2", 45) + ". Mostrar Clientes");
            System.out.println(tabulador + colores.consola("3", 45) + ". Mostrar Clientes Standard");
            System.out.println(tabulador + colores.consola("4", 45) + ". Mostrar Clientes Premium");
            System.out.println(tabulador + colores.consola("0", 42) + ". Volver");
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
        System.out.println(controlador.printListaClientesAll());
    }
    public void printListClientesPremium() {
        System.out.println(controlador.printListaClientesPremium());
    }

    public void printListClientesStandard() {
        System.out.println(controlador.printListaClientesStandard());
    }

    /* Gestión Pedidos */
    private void printMenuPedidos() throws EscrituraAccesoDatoException {
        boolean salir = false;
        char opt;
        do {
            printCabecera("Gestión Pedidos");
            System.out.println(tabulador + colores.consola("1", 45) + ". Añadir Pedido");
            System.out.println(tabulador + colores.consola("2", 45) + ". Mostrar pedidos");
            System.out.println(tabulador + colores.consola("3", 45) + ". Eliminar pedido");
            System.out.println(tabulador + colores.consola("0", 42) + ". Volver");
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
        // TODO try catch de parseInt?
        System.out.print("Ingrese el número de pedido a eliminar: ");
        int numPedido = parseInt(teclado.nextLine());
        System.out.println(controlador.deletePedido(numPedido));
    }

    private void printListPedidos() {
        System.out.println(controlador.printListaPedidos());
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
        // TODO Check articulo
        // TODO Pedir otros datos
        // TODO insertar

    }
}

