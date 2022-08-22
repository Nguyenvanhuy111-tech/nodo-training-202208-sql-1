package Unit12;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WebRowSetExample {
    public static void main(String[] args) {
        try {
           ResultSet rs = Common.statement().executeQuery("SELECT * FROM MP_Student");
            File file = new File("output.xml");
            FileWriter writer = new FileWriter(file);
            WebRowSet wrs = RowSetProvider.newFactory().createWebRowSet();
            wrs.writeXml(rs,writer);

            Desktop.getDesktop().open(file);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
