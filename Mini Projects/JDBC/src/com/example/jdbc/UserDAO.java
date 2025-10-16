// UserDAO.java
package JDBC.src.com.example.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_db";
    private static final String USER = "your_user";
    private static final String PASSWORD = "your_password";

    // Get connection method
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Scenario 1: getUserType by userID
    public String getUserType(String userID) {
        String sql = "SELECT userType FROM Users WHERE userID=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("userType");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Scenario 2: getIncorrectAttempts by userID
    public int getIncorrectAttempts(String userID) {
        String sql = "SELECT incorrectAttempts FROM Users WHERE userID=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("incorrectAttempts");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Scenario 3: changeUserType
    public boolean changeUserType(String userID, String newUserType) {
        String sql = "UPDATE Users SET userType=? WHERE userID=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newUserType);
            ps.setString(2, userID);
            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Scenario 4: getLockStatus by userID
    public int getLockStatus(String userID) {
        String sql = "SELECT lockStatus FROM Users WHERE userID=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("lockStatus");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Scenario 5: changeName and Password
    public boolean changeNameAndPassword(String userID, String newName, String newPassword) {
        String sql = "UPDATE Users SET name=?, password=? WHERE userID=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setString(2, newPassword);
            ps.setString(3, userID);
            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Scenario 6: addUser with userBean
    public boolean addUser(UserBean user) {
        String sql = "INSERT INTO Users (userID, password, name, incorrectAttempts, lockStatus, userType) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUserID());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setInt(4, user.getIncorrectAttempts());
            ps.setInt(5, user.getLockStatus());
            ps.setString(6, user.getUserType());
            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Scenario 7: getUsers by userType
    public List<UserBean> getUsers(String userType) {
        List<UserBean> users = new ArrayList<>();
        String sql = "SELECT * FROM Users WHERE userType=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userType);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserBean user = new UserBean();
                user.setUserID(rs.getString("userID"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setIncorrectAttempts(rs.getInt("incorrectAttempts"));
                user.setLockStatus(rs.getInt("lockStatus"));
                user.setUserType(rs.getString("userType"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Scenario 8: getName by userID
    public String getName(String userID) {
        String sql = "SELECT name FROM Users WHERE userID=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
