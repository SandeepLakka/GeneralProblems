package io.github.sandeeplakka.general.problems.pattern.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonPatternV01Test {


    @Test
    public void testNormally() {
        SingletonTest.testNormally(SingletonPatternV01::getInstance);
    }

    @Test
    public void testParallelly() {
        SingletonTest.testParallelly(SingletonPatternV01::getInstance);
    }
}