package io.github.sandeeplakka.general.problems.pattern.singleton;

import org.junit.jupiter.api.Test;


class OnDemandSingletonTest {

    @Test
    void testGetInstanceNormally() {
        SingletonTest.testNormally(OnDemandSingleton::getInstance);
    }

    @Test
    void testGetInstanceParallelly() {
        SingletonTest.testParallelly(OnDemandSingleton::getInstance);
    }


}