package databased.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static String url  = "jdbc:mysql://172.105.85.34:3306/online_store_BD";
    private static String user = "databased";
    private static String pass = "P@ssX0rra!";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }
}
