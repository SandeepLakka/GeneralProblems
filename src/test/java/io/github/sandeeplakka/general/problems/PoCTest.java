package io.github.sandeeplakka.general.problems;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import io.github.sandeeplakka.general.problems.exception.NYI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
}