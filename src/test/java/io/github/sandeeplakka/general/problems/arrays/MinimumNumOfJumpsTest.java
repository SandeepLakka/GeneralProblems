package io.github.sandeeplakka.general.problems.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumOfJumpsTest {

    private MinimumNumOfJumps thisObj;

    @BeforeEach
    public void init() {
        thisObj = new MinimumNumOfJumps();
    }

    @Test
    @DisplayName("Test regular cases")
    public void testRegulars() {
        assertEquals(3, thisObj.minJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
        assertEquals(2, thisObj.minJumps(new int[]{1, 4, 3, 2, 6, 7}));
        assertEquals(4, thisObj.minJumps(new int[]{2, 3, 1, 1, 2, 4, 2, 0, 1, 1}));
    }

}