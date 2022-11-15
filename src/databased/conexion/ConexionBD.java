package databased.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static ConexionBD instance;
    private Connection conexion;
    private String url = "jdbc:mysql://172.105.85.34:3306/online_store";
    private String user = "toni";//"databased";
    private String pass = "P@ssX0rra!";


    private ConexionBD() {

        try {
            this.conexion = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Connection getConexion() {
        return conexion;
    }

    public static synchronized ConexionBD getInstance() {
        if (instance == null) {
                instance = new ConexionBD();
                System.out.println("Instancia creada correctamente");
        }
        return instance;
    }

    public void closeConexion(){
            instance = null;
    }

}