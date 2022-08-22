package Unit12;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JdbcMetadataExample {
    public static void main(String[] args) throws SQLException {
        try {
            DatabaseMetaData metaData = Common.connection().getMetaData();

            System.out.println("Db version "+metaData.getDatabaseMajorVersion());
            System.out.println("Driver name "+metaData.getDriverName());
        }finally {
            Common.connection().close();
        }
    }
}
