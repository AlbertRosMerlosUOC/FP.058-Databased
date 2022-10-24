package databased.vista;

import databased.controlador.Controlador;
import databased.modelo.Datos;

public class OnlineStore {
    public static void main(String[] args) {

        GestionOS view = new GestionOS();
        Datos model = new Datos();
        Controlador ctrl = new Controlador(model,view );
        System.out.println("Test MVC OnlineStore");
        //Arrancar el menu de la vistas
        view.run();
    }
}
