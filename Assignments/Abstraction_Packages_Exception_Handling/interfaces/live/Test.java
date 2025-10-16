package Assignments.Abstraction_Packages_Exception_Handling.interfaces.live;

import Assignments.Abstraction_Packages_Exception_Handling.interfaces.music.Playable;
import Assignments.Abstraction_Packages_Exception_Handling.interfaces.music.string.Veena;
import Assignments.Abstraction_Packages_Exception_Handling.interfaces.music.wind.Saxophone;



public class Test {
    public static void main(String[] args) {
        Veena v = new Veena();
        Playable veena = v;

        Saxophone s = new Saxophone(); 
        Playable saxo = s;

        veena.play(); 
        saxo.play(); 
    }
}
