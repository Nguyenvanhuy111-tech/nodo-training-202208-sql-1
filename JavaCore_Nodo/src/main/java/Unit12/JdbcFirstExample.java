package Unit12;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcFirstExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            connection = DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
            statement = connection.createStatement();
//            String sql ="create table MP_Student"
//                    +"("
//                    +"id int primary key ,"
//                    +"name varchar(100),"
//                    +"age int default (20)"
//                    +")";

//            String seq = "create sequence SEQ_Student_MP start with 1 increment by 1;";


//            System.out.println(statement.execute(sql));
//            System.out.println(statement.execute(seq));

            statement.execute("insert into MP_Student(id,name,age)values (SEQ_Student_MP.nextval,'Tran Van B',20)");
            statement.execute("insert into MP_Student(id,name,age)values (SEQ_Student_MP.nextval,'Tran Thi B',22)");
            statement.execute("insert into MP_Student(id,name,age)values (SEQ_Student_MP.nextval,'Nguyen Van A',18)");

            System.out.println("Create database successful!");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            statement.close();
            connection.close();

        }
    }
}
