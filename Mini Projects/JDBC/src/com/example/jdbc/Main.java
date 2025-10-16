// Main.java
package JDBC.src.com.example.jdbc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        // Scenario 1: Get UserType
        System.out.println("UserType for AB1001: " + dao.getUserType("AB1001"));

        // Scenario 2: Get Incorrect Attempts
        System.out.println("Incorrect attempts for TA1002: " + dao.getIncorrectAttempts("TA1002"));

        // Scenario 3: Change UserType
        boolean changed = dao.changeUserType("RS1003", "Admin");
        System.out.println("Changed UserType for RS1003: " + changed);

        // Scenario 4: Get LockStatus
        System.out.println("Lock status for AB1001: " + dao.getLockStatus("AB1001"));

        // Scenario 5: Change Name and Password
        boolean updated = dao.changeNameAndPassword("TA1002", "Prasath Kumar", "newpassword123");
        System.out.println("Name and Password updated for TA1002: " + updated);

        // Scenario 6: Add new User
        UserBean newUser = new UserBean();
        newUser.setUserID("XY1004");
        newUser.setPassword("xy1004pass");
        newUser.setName("New User");
        newUser.setIncorrectAttempts(0);
        newUser.setLockStatus(0);
        newUser.setUserType("Employee");
        boolean added = dao.addUser(newUser);
        System.out.println("New User added: " + added);

        // Scenario 7: Get Users by userType
        List<UserBean> admins = dao.getUsers("Admin");
        System.out.println("Admin Users:");
        admins.forEach(user -> System.out.println(user.getUserID() + " " + user.getName()));

        // Scenario 8: Get Name by userID
        System.out.println("Name for user AB1001: " + dao.getName("AB1001"));
    }
}

