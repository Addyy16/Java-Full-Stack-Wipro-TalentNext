package HtmlAndJavascript.servlet_jsp_project.src.com.example;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        try {
            // Assuming DB connection method getConnection()
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE userid=? AND password=?");
            ps.setString(1, userid);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                HttpSession session = request.getSession();
                session.setAttribute("userid", userid);
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("login.html?error=true");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
