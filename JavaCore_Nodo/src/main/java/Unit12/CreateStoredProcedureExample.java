package Unit12;

import java.sql.SQLException;

public class CreateStoredProcedureExample {
    public static void main(String[] args) throws SQLException {
        Common.statement().executeUpdate("create procedure getage(stream_name VARCHAR(255),out age int)"+
                " parameter style java reads "+
                " sql data language java external name "+
                " 'jdbc.DbFunction.getAge'");
        System.out.println("Done");

        Common.connection().close();
    }
}
