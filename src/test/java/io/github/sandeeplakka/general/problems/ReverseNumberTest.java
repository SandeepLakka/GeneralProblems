package io.github.sandeeplakka.general.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class ReverseNumberTest {

    static final ReverseNumber reverseNumber = new ReverseNumber();

    Function<Integer, Integer> reverseIt = number -> reverseNumber.getReversedNumber(number);

    @Test
    @DisplayName("Test Positive Numbers")
    void testPositiveNumbers() {
        int tc1 = 123456789, er1 = 987654321;
        int tc2 = 12, er2 = 21;
        int tc3 = 1001, er3 = 1001;

        assertEquals(er1, reverseNumber.getReversedNumber(tc1));
        assertEquals(er2, reverseNumber.getReversedNumber(tc2));
        assertEquals(er3, reverseNumber.getReversedNumber(tc3));

    }

    @Test
    @DisplayName("Test Negative numbers")
    void testNegativeNumbers() {
        int tc1 = -12345, er1 = -54321;
        int tc2 = -1204, er2 = -4021;
        int tc3 = -27, er3 = -72;

        assertEquals(er1, reverseIt.apply(tc1));
        assertEquals(er2, reverseIt.apply(tc2));
        assertEquals(er3, reverseIt.apply(tc3));

    }
    @Test
    @DisplayName("Test Corner cases")
    void testCornerCases() {
        int tc1 = 3, er1 = 3;
        int tc2 = 100, er2 = 1; //001 is 1 :)
        int tc3_1, tc3_2, er3_1, er3_2;
        tc3_1 = 0;
        tc3_2 = -0;
        er3_1 = 0;
        er3_2 = -0;

        assertEquals(er1, reverseIt.apply(tc1));
        assertEquals(er2, reverseIt.apply(tc2));

        assertAll(
                () -> assertEquals(er3_1, reverseIt.apply(tc3_1)),
                () -> assertEquals(er3_2, reverseIt.apply(tc3_1))
        );

        assertTrue(Boolean.logicalAnd(er3_1 == reverseIt.apply(tc3_2),
                er3_2 == reverseIt.apply(tc3_2)));
    }
}