<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession session = request.getSession(false);
    if(session == null || session.getAttribute("userid") == null){
        response.sendRedirect("login.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>Welcome: <%= session.getAttribute("userid") %></h2>
    <p><a href="changePassword.html">Change Password</a></p>
    <p><a href="logout">Logout</a></p>
</body>
</html>
