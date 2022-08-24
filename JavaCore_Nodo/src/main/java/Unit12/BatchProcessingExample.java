package Unit12;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BatchProcessingExample {
    public static void main(String[] args) throws SQLException {

        for(int i =0;i<20;i++){

            String name = "Tran Van "+i;
            int age =20+i;
            String sql = "insert into MP_Student(id, name,age) values "+
                    "("+"SEQ_Student_MP.nextval"+",'"+name+"',"+age+")";
            Common.statement().addBatch(sql);
        }
        Common.statement().executeBatch();
        ResultSet rs;
        rs = Common.statement().executeQuery("select  count(*) from STUDENT_HUY");
        if(rs.next()){
            System.out.println("total records ="+rs.getInt(1));
            Common.connection().close();
            Common.statement().close();
        }
    }
}
