package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/UserPreferenceServlet")
public class PreferenceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Simulate login
        String username = (String) session.getAttribute("username");
        if (username == null) {
            username = "JohnDoe";
            session.setAttribute("username", username);
        }

        // Check for theme cookie
        String theme = "light";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("theme".equals(c.getName())) {
                    theme = c.getValue();
                }
            }
        }

        // Update theme if user selects new
        String newTheme = request.getParameter("theme");
        if (newTheme != null && !newTheme.isEmpty()) {
            theme = newTheme;
            Cookie themeCookie = new Cookie("theme", theme);
            themeCookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
            response.addCookie(themeCookie);
        }

        // Output
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Welcome, " + username + "!</h2>");
        response.getWriter().println("<p>Current Theme: " + theme + "</p>");
        response.getWriter().println("<form method='get'>");
        response.getWriter().println("Select Theme: <select name='theme'>");
        response.getWriter().println("<option value='light'>Light</option>");
        response.getWriter().println("<option value='dark'>Dark</option>");
        response.getWriter().println("</select>");
        response.getWriter().println("<input type='submit' value='Save'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }
}
