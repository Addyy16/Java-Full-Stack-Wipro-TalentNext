// Hero.java
package Assignments.Abstraction_Packages_Exception_Handling.packages.solution3.com.automobile.twowheeler;

import Assignments.Abstraction_Packages_Exception_Handling.packages.solution3.com.automobile.Vehicle;

public class Hero extends Vehicle {
    int speed = 80;

    public int getSpeed() {
        return speed;
    }

    public void radio() {
        System.out.println("Playing Radio!!!");
    }


    @Override
    public String getModelName() {
        return "Hero";
    }

    @Override
    public String getRegistrationNumber() {
        return "KA1CR21CS027";
    }

    @Override
    public String getOwnerName() {
        return "Anchal Singh";
    }

}
