package nl.hva.ict.se.ads;

import java.util.*;

/**
 * Holds the name, archer-id and the points scored for 30 arrows.
 *
 * Archers MUST be created by using one of the generator methods. That is way the constructor is private and should stay
 * private. You are also not allowed to add any constructor with an access modifier other then private unless it is for
 * testing purposes in which case the reason why you need that constructor must be contained in a very clear manner
 * in your report.
 */
public class Archer {
    public static int MAX_ARROWS = 3;
    public static int MAX_ROUNDS = 10;
    private static Random randomizer = new Random();
    private final int id; // Once assigned a value is not allowed to change.
    private String firstName;
    private String lastName;
    private static int lastId = 100000;

    private int [][] scores = new int [MAX_ROUNDS][MAX_ARROWS]; // Scored attribute is a 2D array where the first box is the round and 2nd box is the arrows.


    /**
     * Constructs a new instance of bowman and assigns a unique ID to the instance. The ID is not allowed to ever
     * change during the lifetime of the instance! For this you need to use the correct Java keyword.Each new instance
     * is a assigned a number that is 1 higher than the last one assigned. The first instance created should have
     * ID 100000;
     *
     * @param firstName the archers first name.
     * @param lastName the archers surname.
     */
    private Archer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = lastId++;
    }

    /**
     * Constructs a 'fake' archer to be used in unit tests.
     */
    public Archer() {
        this.id = 100;
        firstName = "John";
        lastName = "Smith";
    }

    /**
     * Registers the point for each of the three arrows that have been shot during a round. The <code>points</code>
     * parameter should hold the three points of the round, one per arrow.
     *
     * @param round the round for which to register the points.
     * @param points the points shot during the round.
     */
    public void registerScoreForRound(int round, int[] points) {
        if (round < 0 || round > MAX_ROUNDS) { // Checks if round is not negative or exceeds the max rounds
            throw new IllegalArgumentException("Round numbers are wrong");
        }
        if (points.length != MAX_ARROWS) { // If length of points is higher than the arrow count also throws an exception.
            throw new IllegalArgumentException("Number of points is wrong");
        }
        scores[round] = Arrays.copyOf(points, MAX_ARROWS); // Creates a copy of the points array. Then future code will use this instead of changing the stored scores after a match.
    }

    /**
     * @return The total score of an Archer, so the sum of all arrows of all rounds
     */
    public int getTotalScore() {
        int totalScore = 0;
        for (int rndCounter = 0; rndCounter < MAX_ROUNDS; rndCounter++) {
            for (int arrowCounter = 0; arrowCounter < MAX_ARROWS; arrowCounter++) {
                totalScore += scores[rndCounter][arrowCounter];
            }
        }
        return totalScore;
    }


    /**
     * @return The weighted score, see documentation.
     */
    public int getWeightedScore() {
        int weightedScoreSum = 0;
        int[] scoreCount = new int[11]; // Array which counts the occurences of each score.
        int [] multipliers = {0, 1, 2, 3, 4, 6, 8 , 10, 13, 16, 20}; // Score multipliers as described in assignment. This is ordered by multiplier from 0 - 10.

        for (int[] roundScores : scores) {  // Iterates over each array of scores in the scores collection.
            for (int score : roundScores) { // Iterates over each individual score in roundScores.
                scoreCount[score]++;        // Increases the count of a score if it's found in roundScores. With this I can collect how often a specific score is registered.
            }
        }
        for (int i = 0; i < scoreCount.length; i++) {           // Loops until the end until scoreCount.length is reached.
            weightedScoreSum += scoreCount[i] * multipliers[i]; // Multiplies the scoreCount with the multiplier and adds it to the sum.
        }
        weightedScoreSum -= scoreCount[0] * 10; // Calculates the penalty of the amount of missed arrows to the sum.
        return weightedScoreSum;
    }
    /*
    Aantal -  X
    10      - x20
    9       - x16
    8       - x13
    7       - x10
    6       - x8
    5       - x6
    4       - x4
    3       - x3
    2       - x2
    1       - x1
     */


    /**
     * This methods creates a List of archers.
     *
     * @param nrOfArchers the number of archers in the list.
     * @return
     */
    public static List<Archer> generateArchers(int nrOfArchers) {
        List<Archer> archers = new ArrayList<>(nrOfArchers);
        for (int i = 0; i < nrOfArchers; i++) {
            Archer archer = new Archer(Names.nextFirstName(), Names.nextSurname());
            letArcherShoot(archer, i % 100 == 0);
            archers.add(archer);
        }
        return archers;

    }

    public int getId() {
        return id;
    }

    private static void letArcherShoot(Archer archer, boolean isBeginner) {
        for (int round = 0; round < MAX_ROUNDS; round++) {
            archer.registerScoreForRound(round, shootArrows(isBeginner ? 0 : 1));
        }
    }

    private static int[] shootArrows(int min) {
        int[] points = new int[MAX_ARROWS];
        for (int arrow = 0; arrow < MAX_ARROWS; arrow++) {
            points[arrow] = shoot(min);
        }
        return points;
    }

    private static int shoot(int min) {
        return Math.max(min, randomizer.nextInt(11));
    }

    @Override
    public String toString() {
        return getId() + " (" + getTotalScore() + " / " + getWeightedScore() + ") " + firstName + " " + lastName;
    }
}
