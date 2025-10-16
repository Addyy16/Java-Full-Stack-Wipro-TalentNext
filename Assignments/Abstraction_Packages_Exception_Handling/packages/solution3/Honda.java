// Honda.java
package Assignments.Abstraction_Packages_Exception_Handling.packages.solution3;

import Assignments.Abstraction_Packages_Exception_Handling.packages.solution3.com.automobile.Vehicle;

public class Honda extends Vehicle {
    int speed = 120;

    public int getSpeed() {
        return speed;
    }

    public void cdplayer() {
        System.out.println("Controlling CD Player!!!");
    }

    @Override
    public String getModelName() {
        return "Honda";
    }

    @Override
    public String getRegistrationNumber() {
        return "KA1CR21CS027";
    }

    @Override
    public String getOwnerName() {
        return "Ms. Anchal Singh";
    }
}
