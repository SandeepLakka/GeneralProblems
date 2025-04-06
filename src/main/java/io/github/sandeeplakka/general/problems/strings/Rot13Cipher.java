package io.github.sandeeplakka.general.problems.strings;

/**
 * Problem Statement : ROT13 is a simple letter substitution cipher that replaces a letter with the letter 13 letters
 * after it in the alphabet. ROT13 is an example of the Caesar cipher.
 * <p>
 * Create a function that takes a string and returns the string ciphered with Rot13. If there are numbers or
 * special characters included in the string, they should be returned as they are. Only letters from the latin/english
 * alphabet should be shifted, like in the original Rot13 "implementation".
 */
public class Rot13Cipher {
    
    public String rot13(String str) {
        char[] out = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char input = str.charAt(i);
            char output = transformer(input);
            out[i] = output;
        }
        return new String(out);
    }

    private char transformer(char input) {
        char resp = input;
        if (Character.isLowerCase(input)) {
            resp = (char) ('a' + (input - 'a' + 13) % 26);
        } else if (Character.isUpperCase(input)) {
            resp = (char) ('A' + (input - 'A' + 13) % 26);
        }
        return resp;
    }

}
