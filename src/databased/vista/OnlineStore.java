package databased.vista;

import databased.modelo.EscrituraAccesoDatoException;

import java.util.Scanner;

public class OnlineStore {
    public static void main(String[] args) throws EscrituraAccesoDatoException {
        GestionOS gestion = new GestionOS();
        gestion.inicio();
    }
}
