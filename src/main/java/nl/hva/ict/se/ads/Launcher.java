package nl.hva.ict.se.ads;

import javax.swing.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        List<Archer> unsortedArcherList = Archer.generateArchers(25);
        for (Archer archer : unsortedArcherList) {
            System.out.println(archer);
        }

        System.out.println();
        System.out.println("------- sorteren op Id ---------");
        Collections.sort(unsortedArcherList);
        for (Archer archer : unsortedArcherList) {
            System.out.println(archer);
        }

        System.out.println();
        System.out.println("------- sorteren op achternaam ---------");
        Collections.sort(unsortedArcherList, new Archer.LastNameComparator());
        for (Archer archer : unsortedArcherList) {
            System.out.println(archer);
        }

        System.out.println();
        System.out.println("------- sorteren op hoogste score (schema 1) ---------");
        Collections.sort(unsortedArcherList, new Archer.schema1Comparator());
        for (Archer archer : unsortedArcherList) {
            System.out.println(archer);
        }

        System.out.println();
        System.out.println("------- sorteren op top rondes (schema 2)---------");
        Collections.sort(unsortedArcherList, (a1, a2) -> {
            int topRoundsComparison = Integer.compare(a2.getTopRounds(), a1.getTopRounds());
            if (topRoundsComparison != 0) {
                return topRoundsComparison;
            } else {
                int tenComparison = Integer.compare(a2.getTenScores(), a1.getTenScores());
                if (tenComparison != 0) {
                    return tenComparison;
                } else {
                    return Integer.compare(a1.getId(), a2.getId());
                }
            }
        });
        for (Archer archer : unsortedArcherList) {
            System.out.println(archer);
        }


        System.out.println();
        System.out.println("------- efficiëntie van sorteer algoritmes ---------");
        // TODO
    }
}
