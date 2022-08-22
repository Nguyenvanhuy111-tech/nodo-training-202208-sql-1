package Unit12;

import java.sql.*;

public class SelectDataExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
        statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * from MP_Student");
        while (rs.next()){
            Integer id = rs.getInt("id");
            String name = rs.getNString(2);
            Integer age = rs.getInt(3);

            System.out.println(id+"\t"+name+"\t"+age);
        }
        rs.close();
        connection.close();
    }
}
