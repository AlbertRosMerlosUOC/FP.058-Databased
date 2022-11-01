package databased.vista;

import databased.controlador.Controlador;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
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

    public void inicio(){
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
    public void printMenuArticulos(){
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

    public void printAddArticulo(){
        System.out.print("Ingrese código alfanumérico del Artículo: ");
        String codigo = teclado.nextLine();
        System.out.print("Ingrese descripción del Artículo: ");
        String descripcion =  teclado.nextLine();
        boolean continuar;
        double precioVenta= 0;
        do {
            try {
                continuar = false;
                System.out.print("Ingrese precio de venta del Artículo: ");
                precioVenta = getDecimalTeclado(teclado);
            } catch (NoDecimalInsertException e) {
                System.out.println(e.getMessage());
                continuar = true;
            }
            teclado.nextLine();
        }while(continuar);

        double gastosEnvio = 0;
        do {
            try {
                continuar = false;
                System.out.print("Ingrese gastos de envío del Artículo: ");
                gastosEnvio = getDecimalTeclado(teclado);
            } catch (NoDecimalInsertException e) {
                System.out.println(e.getMessage());
                continuar=true;
            }
            teclado.nextLine();
        }while(continuar);

        int tiempoPreparacion = 0;
        do {
            try {
                continuar = false;
                System.out.print("Ingrese tiempo de preparación del Artículo: ");
                tiempoPreparacion = getEnteroTeclado(teclado);
            } catch (NoEnteroInsertException e) {
                System.out.println(e.getMessage());
                continuar=true;
            }
            teclado.nextLine();
        }while(continuar);

        boolean addOkArt = controlador.addArticulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
        if (addOkArt) {
            System.out.println("Artículo " + codigo + " creado correctamente");
        } else {
            System.out.println("El código de artículo " + codigo + " es erróneo, ya existe");
        }
    }

    public void printListArticulos() {
        System.out.println(controlador.listArticulos());
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
            System.out.println(colores.consola("Cliente " + email + " creado correctamente", 43));
        } else{
            System.out.println(colores.consola("El email " + email + " ya existe", 42));
        }
    }

    private boolean printGetTipoCliente() {
        do {
            char tipoCliente = printGetOpcion("Seleccione el tipo de cliente: [(1: Standard),(2: Premium)]");
            if (tipoCliente == '1') {
                return true;
            } else if (tipoCliente == '2') {
                return false;
            }else{
                System.out.println(colores.consola("Opción invalida. Selecione [(1: Standard),(2: Premium)]", 44));
            }
        }while(true);
    }
    public void printListClientesStandard() {
        System.out.println(controlador.listClientesStandard());
    }
    public void printListClientesAll(){
        System.out.println(controlador.listClientes());
    }
    public void printListClientesPremium() {
        System.out.println(controlador.listClientesPremium());
    }



    /* Gestión Pedidos */
    private void printMenuPedidos(){
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
        boolean continuar;
        int numPedido = 0;
        do {
            try {
                continuar = false;
                System.out.print("Ingrese el número de pedido a eliminar: ");
                numPedido = getEnteroTeclado(teclado);
            } catch (NoEnteroInsertException e) {
                System.out.println(e.getMessage());
                continuar=true;
            }
            teclado.nextLine();
        } while (continuar);
        System.out.println(controlador.deletePedido(numPedido));
    }

    private void printListPedidos() {
        System.out.println(controlador.listPedidos());
    }

    private void printAddPedido() {

        String codigo;
        int cantidad;
        System.out.print("Ingrese el email del cliente: ");
        String email = teclado.nextLine();
        boolean existe = controlador.existCliente(email);
        if (!(existe)) {
            System.out.println(colores.consola("El cliente informado no existe. Para poder continuar deberá crear un nuevo cliente.", 44));
            do {
                printAddCliente(email);
            } while(!(controlador.existCliente(email))); // Se crea un bucle para controlar errores en la inserción del cliente.
        }
        do {
            System.out.print("Ingrese código alfanumérico del Artículo: ");
            codigo = teclado.nextLine();

            if (!(codigo.equals("SALIR"))) {
                existe = controlador.existArticulo(codigo);
                if (!(existe))
                    System.out.println(colores.consola("El artículo informado no existe. Por favor, ingrese un código de artículo valido (o SALIR para salir)", 44));
            }
        } while (!(existe) && (!(codigo.equals("SALIR"))));

        if (!(codigo.equals("SALIR"))) {
            boolean continuar;
            cantidad = 0;
            do {
                try {
                    continuar = false;
                    System.out.print("Ingrese la cantidad de artículos: ");
                    cantidad = getEnteroTeclado(teclado);
                } catch (NoEnteroInsertException e) {
                    System.out.println(e.getMessage());
                    continuar=true;
                }
                teclado.nextLine();
            } while (continuar);

            if (controlador.addPedido(controlador.getClienteByEmail(email),controlador.getArticuloByCodigo(codigo),cantidad, LocalDateTime.now())) {
                System.out.println(colores.consola("Pedido creado correctamente", 43));
            } else {
                System.out.println(colores.consola("Error en la creación del pedido", 42));
            }
        } else {
            System.out.println(colores.consola("Acción cancelada por el usuario", 42));
        }
    }

    private int getEnteroTeclado(Scanner teclado) throws NoEnteroInsertException {

        try {
            return teclado.nextInt();
        } catch( InputMismatchException e) {
            throw new NoEnteroInsertException();
        }
    }
    private double getDecimalTeclado(Scanner teclado) throws NoDecimalInsertException {

        try {
            return teclado.nextDouble();
        } catch( InputMismatchException e) {
            throw new NoDecimalInsertException();
        }
    }
}


