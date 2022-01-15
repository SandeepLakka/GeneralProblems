package io.github.sandeeplakka.general.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountNumberOfOccurrencesTest {

    private CountNumberOfOccurrences countNumberOfOccurrences;

    @BeforeEach
    void init() {
        countNumberOfOccurrences = new CountNumberOfOccurrences();
    }

    @Test
    @DisplayName("Test positive matches")
    void testPositives() {
        String string = "pig pigee pigee pig pig";
        String sub = "pig";
        int expResult = 5;
        assertEquals(expResult, countNumberOfOccurrences.getCountOfOccurences(string, sub));

        string = "hello there!";
        sub = "he";
        expResult = 2;
        assertEquals(expResult, countNumberOfOccurrences.getCountOfOccurences(string, sub));

        string = "heee yaaaw";
        sub = "ee";
        expResult = 1;
        assertEquals(expResult, countNumberOfOccurrences.getCountOfOccurences(string, sub));
    }

    @Test
    @DisplayName("Test negative matches")
    void testNegatives() {
        //Result for negative cases
        int expResult = -1;

        String string = "pig pigee pigee pig pig";
        String sub = "piggy";

        assertEquals(expResult, countNumberOfOccurrences.getCountOfOccurences(string, sub));

        string = "hey there!";
        sub = "hello";
        assertEquals(expResult, countNumberOfOccurrences.getCountOfOccurences(string, sub));

        string = "hell lot of fun";
        sub = "HELL";
        assertEquals(expResult, countNumberOfOccurrences.getCountOfOccurences(string, sub));

    }

    @Test
    @DisplayName("Test exceptional cases")
    public void testExceptionals(){
        String string = "hello";
        String sub = "hell";

        assertThrows(IllegalArgumentException.class,
                () -> countNumberOfOccurrences.getCountOfOccurences(null,sub));
        assertThrows(IllegalArgumentException.class,
                () -> countNumberOfOccurrences.getCountOfOccurences(string, null));
        assertThrows(IllegalArgumentException.class,
                () -> countNumberOfOccurrences.getCountOfOccurences(null, null));

    }


}