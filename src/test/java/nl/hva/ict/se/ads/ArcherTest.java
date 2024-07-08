package nl.hva.ict.se.ads;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ArcherTest {

    private Archer testArcher;

    private void setupArcher() {
        testArcher = new Archer();
        testArcher.registerScoreForRound(0, new int[] {10, 9, 8});
        testArcher.registerScoreForRound(1, new int[] {9, 8, 7});
        testArcher.registerScoreForRound(2, new int[] {8, 7, 6});
        testArcher.registerScoreForRound(3, new int[] {7, 6, 5});
        testArcher.registerScoreForRound(4, new int[] {5, 4, 3});
        testArcher.registerScoreForRound(5, new int[] {4, 3, 2});
        testArcher.registerScoreForRound(6, new int[] {3, 2, 1});
        testArcher.registerScoreForRound(7, new int[] {2, 1, 0});
        testArcher.registerScoreForRound(8, new int[] {10, 10, 10});
        testArcher.registerScoreForRound(9, new int[] {9, 0, 0});
    }

    @Test
    public void archerIdsIncreaseCorrectly() {
        List<Archer> archers = Archer.generateArchers(3);
        assertTrue(archers.get(0).getId() == 100000);
        assertTrue(archers.get(1).getId() == archers.get(0).getId()+ 1);
        assertTrue(archers.get(2).getId() == archers.get(1).getId()+ 1);
    }

    @Test
    public void archerTotalScoreTest() {
        setupArcher();
        int expected = 159;
        int actual = testArcher.getTotalScore();
        assertEquals(expected, actual);
    }

    @Test
    public void archerWeightedScoreTest() {
        setupArcher();
        int expected = 220;
        int actual = testArcher.getWeightedScore();
        assertEquals(expected, actual);
    }

}