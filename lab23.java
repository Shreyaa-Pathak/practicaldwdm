import java.sql.*;

public class lab23 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo_db";
        String user = "root";
        String password = "oracle123";

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("Database Product: " + meta.getDatabaseProductName());
            System.out.println("Database Version: " + meta.getDatabaseProductVersion());
            System.out.println("Driver Name: " + meta.getDriverName());
            System.out.println("Driver Version: " + meta.getDriverVersion());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
