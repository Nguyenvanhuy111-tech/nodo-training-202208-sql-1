package Unit12;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BatchProcessingExample {
    public static void main(String[] args) throws SQLException {
        for (int i = 0; i < 20; i++) {
            String name1 = "Tran Van " + i;
            Integer age = (10 + i);
            String id = "SEQ_Student_MP.nextval";

            StringBuilder sql = new StringBuilder("insert into MP_Student(id,name,age) values ");
            sql.append('(' + id + ',').append('"' + name1 + '"' + ',').append(age).append(')');
//                    Common.statement().execute(String.valueOf(sql));
            Common.statement().addBatch(String.valueOf(sql));
            System.out.println(sql);
        }
        Common.statement().executeBatch();

        ResultSet rs = Common.statement().executeQuery("SELECT COUNT(*) from MP_Student");
        if (rs.next()) System.out.println("Total records = " + rs.getInt(1));
        Common.connection().close();
    }
}
