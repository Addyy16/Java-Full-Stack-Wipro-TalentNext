package HtmlAndJavascript.servlet_jsp_project.src.com.example;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        if(!newPassword.equals(confirmPassword)){
            response.getWriter().println("New Password and Confirm Password do not match.");
            return;
        }

        try {
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE userid=? AND password=?");
            ps.setString(1, userid);
            ps.setString(2, oldPassword);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                PreparedStatement psUpdate = conn.prepareStatement("UPDATE users SET password=? WHERE userid=?");
                psUpdate.setString(1, newPassword);
                psUpdate.setString(2, userid);
                psUpdate.executeUpdate();
                psUpdate.close();
                response.getWriter().println("Password changed successfully.");
            } else {
                response.getWriter().println("Invalid user ID or old password.");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch(Exception e) {
            throw new ServletException(e);
        }
    }
}
