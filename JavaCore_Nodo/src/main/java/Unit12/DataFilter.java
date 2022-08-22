package Unit12;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class DataFilter implements Predicate {
    @Override
    public boolean evaluate(RowSet rs) {
        CachedRowSet crs = (CachedRowSet) rs;
        try {
            return crs.getString("name").indexOf("Nguyen") > -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean evaluate(Object value, int column) throws SQLException {
        return false;
    }

    @Override
    public boolean evaluate(Object value, String columnName) throws SQLException {
        return false;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet();
        frs.setUrl("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
        frs.setCommand("Select * from STUDENT_HUY");
        DataFilter fil = new DataFilter();
        frs.setFilter(frs.getFilter());
        frs.execute();
        System.out.println("ID\tName\t\tAge");
        while (frs.next()) {
            System.out.println("id" + "\t" + frs.getString(2) + "\t" + frs.getInt(3));
        }
    }
}
