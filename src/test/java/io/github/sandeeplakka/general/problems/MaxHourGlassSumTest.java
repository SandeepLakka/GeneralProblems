package io.github.sandeeplakka.general.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxHourGlassSumTest {

    private MaxHourGlassSum maxHourGlassSum;

    @BeforeEach
    public void init() {
        maxHourGlassSum = new MaxHourGlassSum();
    }

    @Test
    @DisplayName("Test 6X6 grid with all positives")
    public void testA6By6GridWithAllPositives() {
        //Not a good way to initialize collection, please excuse :)
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<Integer>() {{
            add(1);
            add(1);
            add(1);
            add(0);
            add(0);
            add(0);
        }});
        input.add(new ArrayList<Integer>() {{
            add(0);
            add(1);
            add(0);
            add(0);
            add(0);
            add(0);
        }});
        input.add(new ArrayList<Integer>() {{
            add(1);
            add(1);
            add(1);
            add(0);
            add(0);
            add(0);
        }});
        input.add(new ArrayList<Integer>() {{
            add(9);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
        }});
        input.add(new ArrayList<Integer>() {{
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
        }});
        input.add(new ArrayList<Integer>() {{
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
            add(20);
        }});

        assertEquals(20, maxHourGlassSum.getMaxHourGlassSum(input));
    }

    @Test
    @DisplayName("Test 6X6 grid with all negatives")
    public void testA6By6GridWithAllNegatives() {
        //Not a good way to initialize collection, please excuse :)
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<Integer>() {{
            add(-1);
            add(-1);
            add(-1);
            add(0);
            add(0);
            add(0);
        }});
        input.add(new ArrayList<Integer>() {{
            add(0);
            add(-1);
            add(0);
            add(0);
            add(0);
            add(0);
        }});
        input.add(new ArrayList<Integer>() {{
            add(-1);
            add(-1);
            add(-1);
            add(0);
            add(0);
            add(0);
        }});
        input.add(new ArrayList<Integer>() {{
            add(-9);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
        }});
        input.add(new ArrayList<Integer>() {{
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
        }});
        input.add(new ArrayList<Integer>() {{
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
            add(-20);
        }});

        assertEquals(0, maxHourGlassSum.getMaxHourGlassSum(input));
    }

    @Test
    @DisplayName("Test edge cases")
    public void testEdgeCases() {
        assertThrows(IllegalArgumentException.class,
                () -> maxHourGlassSum.getMaxHourGlassSum(null));
        assertThrows(IllegalArgumentException.class,
                () -> maxHourGlassSum.getMaxHourGlassSum(new LinkedList<>()));
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>());
        input.add(null);
        assertThrows(IllegalArgumentException.class,
                () -> maxHourGlassSum.getMaxHourGlassSum(input));
        assertThrows(IllegalArgumentException.class,
                () -> maxHourGlassSum.getMaxHourGlassSum(new LinkedList<>()));
    }


}