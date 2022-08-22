package Unit12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
            statement = connection.createStatement();

            statement.execute("insert into MP_Student(id,name,age)values (SEQ_Student_MP.nextval,'Tran Van B',20)");
            statement.execute("insert into MP_Student(id,name,age)values (SEQ_Student_MP.nextval,'Tran Thi B',22)");
            statement.execute("insert into MP_Student(id,name,age)values (SEQ_Student_MP.nextval,'Nguyen Van A',18)");


            System.out.println("Create database successful!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            statement.close();
            connection.close();

        }
    }
}
