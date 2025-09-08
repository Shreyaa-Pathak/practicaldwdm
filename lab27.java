import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class lab27 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo_db";
        String user = "root";
        String password = "oracle123";

        Connection con = null;
        CachedRowSet crs = null;

        try {
            // 1. Create CachedRowSet
            crs = RowSetProvider.newFactory().createCachedRowSet();

            // 2. Set DB connection info and query
            crs.setUrl(url);
            crs.setUsername(user);
            crs.setPassword(password);
            crs.setCommand("SELECT id, name, email FROM Students");
            crs.execute();

            System.out.println("Original Data");
            while (crs.next()) {
                System.out.println(crs.getInt("id") + " - " + crs.getString("name") + " - " + crs.getString("email"));
            }

            // 3. Update offline
            crs.beforeFirst();
            while (crs.next()) {
                if (crs.getInt("id") == 1) {
                    crs.updateString("name", "UpdatedName");
                    crs.updateRow();
                }
            }

            // 4. Reconnect manually and apply changes
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false); 
            crs.acceptChanges(con);

            // 5. Print updated data
            crs.beforeFirst(); 
            System.out.println("\nUpdated Data");
            while (crs.next()) {
                System.out.println(crs.getInt("id") + " - " + crs.getString("name") + " - " + crs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (crs != null) crs.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
