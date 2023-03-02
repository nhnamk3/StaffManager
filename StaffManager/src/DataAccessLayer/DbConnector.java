package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static Connection openConnector(String DB_name, String DB_user, String DB_pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String urlDB = "jdbc:mysql://localhost:3306/" + DB_name;
        try {
            return DriverManager.getConnection(urlDB, DB_user, DB_pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
