package Unit12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Common {
    final static Connection connection() {
        try {
            Connection connection = null;
            Statement statement = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
            statement = connection.createStatement();
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    final static Statement statement() {
        try {
            return connection().createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
