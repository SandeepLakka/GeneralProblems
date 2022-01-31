package io.github.sandeeplakka.general.problems.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameWithNosXorsTest {

    private GameWithNosXors thisObj;

    @BeforeEach
    public void init() {
        thisObj = new GameWithNosXors();
    }

    @Test
    void test_game_with_number() {
        assertArrayEquals(new int[]{1, 10, 3, 1, 3}, thisObj.game_with_number(new int[]{10, 11, 1, 2, 3}, 5));
        assertArrayEquals(new int[]{12, 14, 1, 6}, thisObj.game_with_number(new int[]{5, 9, 7, 6}, 4));
        assertArrayEquals(new int[]{0, 0, 1}, thisObj.game_with_number(new int[]{1, 1, 1}, 3));
    }
}