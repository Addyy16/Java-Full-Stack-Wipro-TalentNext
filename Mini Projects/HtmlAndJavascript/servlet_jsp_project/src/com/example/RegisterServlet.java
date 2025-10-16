package HtmlAndJavascript.servlet_jsp_project.src.com.example;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String state = request.getParameter("state");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");

        try {
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users (userid, password, dob, gender, state, contact, address) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, userid);
            ps.setString(2, password);
            ps.setString(3, dob);
            ps.setString(4, gender);
            ps.setString(5, state);
            ps.setString(6, contact);
            ps.setString(7, address);
            ps.executeUpdate();

            ps.close();
            conn.close();

            response.sendRedirect("login.html");
        } catch(Exception e) {
            throw new ServletException(e);
        }
    }
}
