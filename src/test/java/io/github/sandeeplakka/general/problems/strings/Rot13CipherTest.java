package io.github.sandeeplakka.general.problems.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rot13CipherTest {

    private Rot13Cipher rot13Cipher;

    @BeforeEach
    void init() {
        rot13Cipher = new Rot13Cipher();
    }

    @Test
    void testRot13_basic() {
        assertEquals("grfg", rot13Cipher.rot13("test"), "Input: \"test\"");
        assertEquals("Grfg", rot13Cipher.rot13("Test"), "Input: \"Test\"");
    }

    @Test
    void testRot13_medium() {
        assertEquals("Pbqrjnef", rot13Cipher.rot13("Codewars"), "Input: \"Codewars\"");
        assertEquals("Ehol vf pbby!", rot13Cipher.rot13("Ruby is cool!"), "Input: \"Ruby is cool!\"");
        assertEquals("10+2 vf gjryir.", rot13Cipher.rot13("10+2 is twelve."), "Input: \"10+2 is twelve.\"");

        assertEquals("nopqrstuvwxyzabcdefghijklm", rot13Cipher.rot13("abcdefghijklmnopqrstuvwxyz"), "Input: \"abcdefghijklmnopqrstuvwxyz\"");
        assertEquals("NOPQRSTUVWXYZABCDEFGHIJKLM", rot13Cipher.rot13("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), "Input: \"ABCDEFGHIJKLMNOPQRSTUVWXYZ\"");
    }


}