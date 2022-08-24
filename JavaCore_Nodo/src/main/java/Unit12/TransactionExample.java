package Unit12;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionExample {
    public static void main(String[] args) throws SQLException {

        Common.connection().setAutoCommit(false);


        try {
            for (int i = 0; i < 10; i++) {
                String name = "Tran Van "+i;
                Integer age = 10+i;

                String sql = "insert into MP_Student(id, name,age) values "+
                        "("+"SEQ_Student_MP.nextval"+",'"+name+"',"+age+")";
                Common.statement().executeUpdate(sql);
            }
        }catch (Exception e){
            e.printStackTrace();
            Common.connection().rollback();
        }

        Common.connection().setAutoCommit(true);
        ResultSet rs = Common.statement().executeQuery("SELECT COUNT(*) from MP_Student");
        if (rs.next()) System.out.println("Total records = "+rs.getInt(1));
        Common.connection().close();
        Common.statement().close();

    }
}
