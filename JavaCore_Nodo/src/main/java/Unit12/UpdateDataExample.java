package Unit12;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataExample {
    public static void main(String[] args) throws SQLException {
        PreparedStatement statement = Common.connection().prepareStatement(
                "UPDATE MP_Student SET name = ? WHERE id=?"
        );
        statement.setString(1,"Le THi Z");
        statement.setInt(2,2);
        statement.executeUpdate();
    }
}
