package nl.hva.ict.se.ads;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChampionSelectorTest {
    protected Comparator<Archer> comparator;

    @BeforeEach
    public void createComparator() {
        // Instantiate your own comparator here...
        // comparator = new .....();
    }

    @Test
    public void basicSortAndCollectionSortResultInSameOrder() {
        List<Archer> unsortedArchersForBasicSort = Archer.generateArchers(23);
        List<Archer> unsortedArchersForCollectionSort = new ArrayList<>(unsortedArchersForBasicSort);

        List<Archer> sortedArchersBasicSort = ChampionSelector.basicSort(unsortedArchersForBasicSort, comparator);
        List<Archer> sortedArchersCollectionSort = ChampionSelector.collectionSort(unsortedArchersForCollectionSort, comparator);

        assertEquals(sortedArchersCollectionSort, sortedArchersBasicSort);
    }

}