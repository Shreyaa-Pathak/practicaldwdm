package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final String url = "jdbc:mysql://localhost:3306/demo_db";
    private final String user = "root";
    private final String password = "oracle123";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String idStr = request.getParameter("id");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                response.getWriter().println("JDBC Driver not found: " + e.getMessage());
                return;
            }
            conn = DriverManager.getConnection(url, user, password);

            if ("delete".equals(action) && idStr != null) {
                int id = Integer.parseInt(idStr);
                ps = conn.prepareStatement("DELETE FROM students WHERE id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
            }

            // Fetch all students
            ps = conn.prepareStatement("SELECT * FROM students");
            rs = ps.executeQuery();
            request.setAttribute("resultSet", rs);

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error: " + e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String emailStr = request.getParameter("email");
        String submitValue = request.getParameter("submit");

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                response.getWriter().println("JDBC Driver not found: " + e.getMessage());
                return;
            }
            conn = DriverManager.getConnection(url, user, password);

            int id = Integer.parseInt(idStr);
            if ("Update".equals(request.getParameter("submit"))) {
                // Update
                System.out.println("Updating student: id=" + id + ", name=" + name + ", email=" + emailStr);
                ps = conn.prepareStatement("UPDATE students SET name=?, email=? WHERE id=?");
                ps.setString(1, name);
                ps.setString(2, emailStr);
                ps.setInt(3, id);
                int rows = ps.executeUpdate();
                System.out.println("Rows updated: " + rows);
            } else {
                // Insert
                ps = conn.prepareStatement("INSERT INTO students (id, name, email) VALUES (?, ?, ?)");
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, emailStr);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("StudentServlet");
    }
}
