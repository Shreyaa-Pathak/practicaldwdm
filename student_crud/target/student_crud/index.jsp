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
    Age: <input type="text" name="age" value="<%= request.getParameter("editAge") != null ? request.getParameter("editAge") : "" %>" required>
    <input type="submit" name="submit" value="<%= request.getParameter("editId") != null ? "Update" : "Save" %>">
</form>

<br/>

<!-- Student Table -->
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Actions</th>
    </tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("resultSet");
        if (rs != null) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
    %>
    <tr>
        <td><%= id %></td>
        <td><%= name %></td>
        <td><%= age %></td>
        <td>
            <form action="StudentServlet" method="get" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= id %>">
                <input type="submit" value="Delete">
            </form>
            <form action="index.jsp" method="get" style="display:inline;">
                <input type="hidden" name="editId" value="<%= id %>">
                <input type="hidden" name="editName" value="<%= name %>">
                <input type="hidden" name="editAge" value="<%= age %>">
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
