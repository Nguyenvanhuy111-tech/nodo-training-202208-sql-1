package Unit12;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class JdbcRowSetExample {

    public static void main(String[] args) throws SQLException {
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUrl("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
        jdbcRowSet.setCommand("Select * from MP_Student");
        jdbcRowSet.execute();

        while (jdbcRowSet.next()) {
            System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString(2));
        }



//        jdbcRowSet.first();
//        jdbcRowSet.updateString("name","Hoang van X");
//        jdbcRowSet.commit();
//
//        jdbcRowSet.first();
//        System.out.println(jdbcRowSet.getInt("id")+"\t"+jdbcRowSet.getString(2));
//        jdbcRowSet.absolute(8);

        jdbcRowSet.close();
    }
}
