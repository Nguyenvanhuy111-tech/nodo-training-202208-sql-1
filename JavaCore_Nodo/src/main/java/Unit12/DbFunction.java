package Unit12;

import java.sql.*;

public class DbFunction {
    public static void getAge(String name,int []ages) throws ClassNotFoundException, SQLException {
        Connection connection =null;
        Statement statement =null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT max(age) from STUDENT_HUY where name like '%" + name + "%'");
            ages[0] = rs.next() ? rs.getInt(1) : -1;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int []ages = new int[1];
        getAge("Thi Z",ages);
        System.out.println(ages[0]);
    }
}
