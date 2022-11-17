package databased.vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OnlineStore {

    public static void main(String[] args){

       GestionOS gestion = new GestionOS();
       gestion.inicio();
    }
}
