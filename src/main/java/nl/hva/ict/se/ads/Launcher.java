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
        Collections.sort(unsortedArcherList, new Archer.Schema2Comparator());
        for (Archer archer : unsortedArcherList) {
            System.out.println(archer);
        }

        System.out.println();
        System.out.println("------- efficiëntie van sorteer algoritmes ---------");
        int [] listSizes = {10000, 20000, 40000}; // Initializes the list sizes. The amount given in the assignment took too long.

        for (int size : listSizes) { // Runs through the given sizes in the listSizes Array.
            List<Archer> archers = Archer.generateArchers(size); // Using a list to store all Archers with the gigven generateArchers method. Passing size in the loop to give the amount of archers to create.

            long startTime = System.currentTimeMillis(); // Stores the start time in a long.
            ChampionSelector.basicSort(archers, new Archer.schema1Comparator()); // Calling the sort method. Depending on what is active in the method can be bubble or insertion sort.
            long endTime = System.currentTimeMillis(); // Stores the end time in a long.
            long finalRunTime = endTime - startTime; // Calculates the total time spent before the loop finished.
            System.out.printf("%d: \t Started at: %d ended at: %d total time(ms): %d\n",size, startTime, endTime, finalRunTime);


//            Output using INSERTION SORT:
//            10000: 	 Started at: 1720539910566 ended at: 1720539911718 total time(ms): 1152
//            20000: 	 Started at: 1720539911740 ended at: 1720539916323 total time(ms): 4583
//            40000: 	 Started at: 1720539916344 ended at: 1720539934115 total time(ms): 17771

//            Output using BUBBLE SORT:
//            10000: 	 Started at: 1720539514790 ended at: 1720539524765 total time(ms): 9975
//            20000: 	 Started at: 1720539524779 ended at: 1720539565052 total time(ms): 40273
//            40000: 	 Started at: 1720539565073 ended at: 1720539790313 total time(ms): 225240

            /**
            @CONCLUSION:
             Both methods prove to be highly ineffective. Insertion & Bubble sort both yield an execution time that roughly increases quadratically.
             That means time complexity is O(n^2).
             */
        }
    }
}
