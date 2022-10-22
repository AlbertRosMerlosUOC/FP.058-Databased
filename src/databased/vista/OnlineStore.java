package databased.vista;

import databased.controlador.Controlador;
import databased.modelo.Datos;
import databased.modelo.EscrituraAccesoDatoException;

public class OnlineStore {
    public static void main(String[] args) throws EscrituraAccesoDatoException {
        GestionOS gestion = new GestionOS();
        gestion.inicio();
    }
}
