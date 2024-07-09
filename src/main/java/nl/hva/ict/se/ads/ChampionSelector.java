package nl.hva.ict.se.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of Archer's this class can be used to sort the list using one of two sorting algorithms.
 */
public class ChampionSelector {
    /**
     * This method uses either selection sort or insertion sort for sorting the archers.
     */

    public static List<Archer> basicSort(List<Archer> archers, Comparator<Archer> scoringScheme) {

       // BUBBLE SORT:

//        int n = archers.size(); // Size of the archer list is stored in variable n.
//        boolean swapped;        // Initliazing a boolean to check if a swap was made in the do/while loop.
//        do {
//            swapped = false;    // No swap has been made yet so boolean = false.
//            for (int i = 1; i < n; i++) {   // Iterates over the second element (i=1) until the last element.
//                if (scoringScheme.compare(archers.get(i - 1), archers.get(i)) > 0) { // Checks if archer at (i-1) has to come before or after (i).
//                    Archer tempArcher = archers.get(i - 1); // stores the archer at index (i-1) in tempArcher.
//                    archers.set(i - 1, archers.get(i));     // Sets values of archer at (i-1) at (i).
//                    archers.set(i, tempArcher);             // Sets the value of the tempArcher (i-1) at (i)
//                    swapped = true;                         // Now setting the boolean to true after a swap happened.
//                }
//            }
//        } while (swapped); // Continues running as long as swapped is true.
//        return archers;
//    } // end of BUBBLE SORT



        // INSERTION SORT:

        for (int i = 0; i < archers.size(); i++) {  // For loop that runs through all the items in the archers list.
            Archer currentArcher = archers.get(i);  // Gets the current archer from the loop and stores it as currentArcher.
            int j = i - 1;                          // Initializing a variable one to the left of the index for comparison.
            while (j >= 0 && scoringScheme.compare(archers.get(j), currentArcher) > 0) {    // Runs as long as j is not negative and the archer at index J is greater than currentArcher.
                archers.set(j + 1, archers.get(j)); // If the while loop runs then moves archer from index J to index j+1 (basically i)
                j--;                                // Auto decrement on j to make sure the previous elemented is also checked.
            }
            archers.set(j + 1, currentArcher);      // currentArcher is inserted at the correct position after the loop.
        }
        return archers;

     } // end of INSERTION SORT

    /**
     * This method uses the Java collections sort algorithm for sorting the archers.
     */
    public static List<Archer> collectionSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        Collections.sort(archers, scoringScheme);
        return archers;
    }

}
