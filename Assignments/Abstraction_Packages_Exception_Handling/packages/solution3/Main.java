// Main.java
package Assignments.Abstraction_Packages_Exception_Handling.packages.solution3;

import Assignments.Abstraction_Packages_Exception_Handling.packages.solution3.com.automobile.twowheeler.Hero;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        Honda honda = new Honda();
        
        System.out.println("Hero's speed: " + hero.getSpeed()+" km/hr");
        hero.radio();
        
        System.out.println("Honda's speed: " + honda.getSpeed()+" km/hr");
        honda.cdplayer();
    }
}
