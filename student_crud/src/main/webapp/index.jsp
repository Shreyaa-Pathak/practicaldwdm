<%@ page import="java.sql.*, java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management</title>
</head>
<body>
<h2>Student Records</h2>

<!-- Student Form -->
<form action="StudentServlet" method="post">
    Id: <input type="text" name="id" value="<%= request.getParameter("editId") != null ? request.getParameter("editId") : "" %>" <%= request.getParameter("editId") != null ? "readonly" : "" %>>
    Name: <input type="text" name="name" value="<%= request.getParameter("editName") != null ? request.getParameter("editName") : "" %>" required>
    Email: <input type="text" name="email" value="<%= request.getParameter("editEmail") != null ? request.getParameter("editEmail") : "" %>" required>
    <input type="submit" name="submit" value="<%= request.getParameter("editId") != null ? "Update" : "Save" %>">
</form>

<br/>

<!-- Student Table -->
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("resultSet");
        if (rs != null) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

    %>
    <tr>
        <td><%= id %></td>
        <td><%= name %></td>
        <td><%= email %></td>
        <td>
            <form action="StudentServlet" method="get" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= id %>">
                <input type="submit" value="Delete">
            </form>
            <form action="index.jsp" method="get" style="display:inline;">
                <input type="hidden" name="editId" value="<%= id %>">
                <input type="hidden" name="editName" value="<%= name %>">
                <input type="hidden" name="editEmail" value="<%= email %>">
                <input type="submit" value="Edit">
            </form>
        </td>
    </tr>
    <%
            }
            rs.close();
        }
    %>
</table>
</body>
</html>
