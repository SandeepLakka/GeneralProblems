package io.github.sandeeplakka.general.problems;

import io.github.sandeeplakka.general.problems.exception.NYI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PoCTest {
    private PoC thisObj = new PoC();

    @BeforeEach
    public void init() {
        thisObj = new PoC();
    }

    @Test
    void getLongitude() {
        assertThrows(NYI.class, () ->
                thisObj.getAdjustedTime("Hyderabad"));
    }

    @Test
    void testExceptionals() {
        assertThrows(RuntimeException.class,
                () -> thisObj.getAdjustedTime("null&json_callback=\"\""));

        assertThrows(AssertionError.class,
                () -> thisObj.getAdjustedTime("json_callback=\"\""));
    }

    @Test
    void testGetLongitude() {
        assertEquals(78, thisObj.getLongitude("Hyderabad"));
        assertEquals(88, thisObj.getLongitude("Kolkata"));
    }
}