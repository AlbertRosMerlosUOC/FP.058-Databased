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
        char opcio;
        do {
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    gestArticulo();
                    break;
                case '2':
// TO-BE-DONE
                    break;
                case '3':
// TO-BE-DONE
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }

    char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2,3 o 0): ");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    char pedirOpcion(String texto) {
        String resp;
        System.out.println(texto);
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    public void gestArticulo() throws EscrituraAccesoDatoException {
        boolean salirArt = false;
        char opcioArt;
        do {
            System.out.println("1. Añadir Artículo");
            System.out.println("2. Mostrar Artículos");
            System.out.println("0. Salir");
            opcioArt = pedirOpcion("Elige una opción (1,2 o 0): ");
            //          opcioArt = pedirOpcion();
            switch (opcioArt) {
                case '1':
                    addArticulo();
                    break;
                case '2':
                    //TBD
                    listArticulo();
                    break;
                case '0':
                    salirArt = true;
            }
        }while (!salirArt);
    }

    public String addArticulo() throws EscrituraAccesoDatoException {
        System.out.println("Ingrese código alfanumérico del Artículo");
        String codigo = teclado.nextLine();
        //habrá que comprobar que este código exista en la lista
        //TBD!!!
        System.out.println("Ingrese descripción del Artículo");
        String descripcion =  teclado.nextLine();
        System.out.println("Ingrese precio de venta del Artículo");
        double precioVenta = teclado.nextDouble();
        System.out.println("Ingrese gastos de envío del Artículo");
        double gastosEnvio = teclado.nextDouble();
        System.out.println("Ingrese tiempo de preparación del Artículo");
        int tiempoPreparacion = teclado.nextInt();

        int addOkArt = controlador.addArticulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
        if(addOkArt == 0){
            System.out.println("Artículo " + codigo + " creado correctamente");
        }else if(addOkArt == 1){
            System.out.println("Error al añadir el artículo" + codigo);
        }else if(addOkArt == 2){
            System.out.println("El código de artículo " + codigo + " es erróneo, ya existe");
        }
        return codigo;
    }
    public void listArticulo(){
        controlador.listArticulos();
    }
}

