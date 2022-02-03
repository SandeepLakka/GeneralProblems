package io.github.sandeeplakka.general.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
A team is working hard to upgrade their tools and frameworks
dependencies in their projects and when it comes to
unit testing framework junit, they are in the process of
upgrading from junit4 to junit5.

but there are numerous asserts which are of the following format
which needs to converted to support junit5 format.

junit4 style:

assertArrayEquals(String message, int[] expecteds, int[] actuals);

junit5 style:
assertArrayEquals(int[] expecteds, int[] actuals, String message);

please help the team in translating the above junit4 tests to support junit5

examples of junit4 asserts
assertArrayEquals(new int[]{2, 4, 6}, doubleIt(new int[]{1, 2, 3}), "Failed for test case [1, 2, 3]");
assertArrayEquals(new int[]{1, 2, 3}, halfIt(new int[]{2, 4, 6}), "Failed for test case [2, 4, 6]");

 */
public class Regex101 {

    public String regex(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input must be valid string");
        }
        String regex = "assertArrayEquals\\((\\\".*\\\"),\\s+(.*)\\);";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        //spaces are left out wantedly, sorry for that :|
        String replacementText = "assertArrayEquals($2, $1);";
        return m.replaceAll(replacementText);
    }
}
