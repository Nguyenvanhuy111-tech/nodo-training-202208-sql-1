package Unit12;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessLogic {
    private final static Logger logger = Logger.getLogger(DataAccessLogic.class.getName());
    Connection connection = null;
    CachedRowSet rowSet;
    int pageSize=1;

    public DataAccessLogic() throws SQLException {
        this.connection = Common.connection();
        rowSet = RowSetProvider.newFactory().createCachedRowSet();
        rowSet.setCommand("SELECT *FROM MP_STUDENT");
        rowSet.execute(connection);
    }

    public void disconnect(){
        try {
            if (connection!=null)connection.close();
        }catch (Exception e){
            logger.log(Level.WARNING,e.toString());
        }
    }

    public List<String> loadName(int page) throws SQLException {
        List names = new ArrayList<>();
        rowSet.setPageSize(pageSize);
        int start = (page-1)*pageSize+1;
        if (!rowSet.absolute(start))return names;

        rowSet.previous();
        while (rowSet.next()){
            names.add(rowSet.getString("name"));
            if (names.size()>=pageSize)break;
        }
        return names;
    }

    int numberOfPage() throws SQLException {
        Statement statement = null;
        try {
            statement = Common.statement();
            ResultSet rs = statement.executeQuery("SELECT count(*) from MP_Student");
            if (!rs.next()) return 0;
            int total = rs.getInt(1);
            int totalPage = total/pageSize;
            if (total%pageSize!=0)totalPage++;
            return totalPage;
        }finally {
            statement.close();
        }
    }
}
