package nl.hva.ict.se.ads;

import java.util.Collections;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        List<Archer> unsortedArcherList = Archer.generateArchers(25);
        for (Archer archer : unsortedArcherList) {
            System.out.println(archer);
        }

        System.out.println();
        System.out.println("------- sorteren op Id ---------");
        // TODO

        System.out.println();
        System.out.println("------- sorteren op achternaam ---------");
        // TODO

        System.out.println();
        System.out.println("------- sorteren op hoogste score (schema 1) ---------");
        // TODO

        System.out.println();
        System.out.println("------- sorteren op top rondes (schema 2)---------");
        // TODO


        System.out.println();
        System.out.println("------- efficiëntie van sorteer algoritmes ---------");
        // TODO
    }
}
