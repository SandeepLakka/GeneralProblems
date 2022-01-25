package io.github.sandeeplakka.general.problems;

import io.github.sandeeplakka.general.problems.exception.NYI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
}