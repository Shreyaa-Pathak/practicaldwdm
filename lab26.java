import java.sql.*;

public class lab26 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo_db";
        String user = "root";
        String password = "oracle123";

        Connection con = null;
        Statement stmt = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            con.setAutoCommit(false);

            stmt.executeUpdate("INSERT INTO Students (id, name, email) VALUES (2, 'Rob', 'rob@gmail.com')");
            stmt.executeUpdate("INSERT INTO Students (id, name, email) VALUES (3, 'Dave', 'dave@gmail.com')");

            //Comment for rollback test and uncomment for commit test
            stmt.executeUpdate("INSERT INTO Students (id, name, age) VALUES (2, 'Error', 20)");

            con.commit();
            System.out.println("Transaction committed.");

        } catch (SQLException e) {
            e.printStackTrace();
            if (con != null) {
                try {
                    System.out.println("Rolling back transaction...");
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
