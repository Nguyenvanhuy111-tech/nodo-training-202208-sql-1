package Unit12;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionExample {
    public static void main(String[] args) throws SQLException {

        Common.connection().setAutoCommit(false);

        for (int i = 0; i < 10; i++) {
            String name1 = "Tran Van "+i;
            Integer age = 10+i;
            String id ="SEQ_Student_MP.nextval";
            Common.statement().executeUpdate("insert into MP_Student(id,name,age) values '('+id+','+('Tran van '+i)+','+(i+10)+');'");
        }
        Common.connection().rollback();

        Common.connection().setAutoCommit(true);
        ResultSet rs = Common.statement().executeQuery("SELECT COUNT(*) from MP_Student");
        if (rs.next()) System.out.println("Total records = "+rs.getInt(1));
        Common.connection().close();

    }
}
