import java.sql.*;

public class lab24 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo_db";
        String user = "root";
        String password = "oracle123";

        Connection con = null;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            String insertData = "INSERT INTO Students (id, name, email) VALUES (1, 'Shreya', 'shreya@gmail.com')";
            stmt.executeUpdate(insertData);
            System.out.println("Data inserted.");

            String updateData = "UPDATE Students SET name = 'Pathak' WHERE id = 1";
            stmt.executeUpdate(updateData);
            System.out.println("Data updated.");

            String deleteData = "DELETE FROM Students WHERE id = 1";
            stmt.executeUpdate(deleteData);

            System.out.println("Operations completed.");
        } catch (SQLException e) {
            e.printStackTrace();
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
