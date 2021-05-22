package io.github.sandeeplakka.general.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OccurencesOfEachCharInStringTest {

    OccurencesOfEachCharInString testClassInstance;


    @BeforeEach
    public void init() {
        testClassInstance = new OccurencesOfEachCharInString();
    }

    @Test
    @DisplayName("Test Empty Strings")
    void testEmptyStrings() {
        Map<Character, Integer> emptyMap  = new HashMap<>();
        String tc1 = "";        //Empty string
        String tc2 = "      ";  //Tabs
        String tc3 = "      ";  //Tabs and spaces
        assertEquals(emptyMap, testClassInstance.getCountOfOccurences(tc1));
        assertEquals(emptyMap, testClassInstance.getCountOfOccurences(tc2));
        assertEquals(emptyMap, testClassInstance.getCountOfOccurences(tc3));

    }

    @Test
    @DisplayName("Test Single Lettered Strings")
    void testSingleLetteredStrings() {
        //TC1
        String tc1 = "aaaaa";
        Map<Character, Integer> er1  = new HashMap<>();
        er1.put('a',5);

        assertEquals(er1, testClassInstance.getCountOfOccurences(tc1));

        //TC2
        String tc2 = "a";
        Map<Character, Integer> er2  = new HashMap<>();
        er2.put('a',1);

        assertEquals(er2, testClassInstance.getCountOfOccurences(tc2));

        //TC3
        String tc3 = "b  ";
        Map<Character, Integer> er3  = new HashMap<>();
        er3.put('b',1);

        assertEquals(er3, testClassInstance.getCountOfOccurences(tc3));
    }

    @Test
    @DisplayName("Test Random strings")
    void testRandomStrings() {
        //TC1
        String tc1 = IntStream.range(0,100).mapToObj(value -> "DAMN").collect(Collectors.joining());
        Map<Character, Integer> er1  = new HashMap<>();
        er1.put('D',100); er1.put('A',100);
        er1.put('M',100); er1.put('N',100);

        assertEquals(er1, testClassInstance.getCountOfOccurences(tc1));
        //TC2
        String tc2 = "hello world";
        Map<Character, Integer> er2  = new HashMap<>();
        er2.put('h',1); er2.put('e',1); er2.put('l',3);
        er2.put('o',2); er2.put('w',1); er2.put('r',1);
        er2.put('d',1);

        assertEquals(er2, testClassInstance.getCountOfOccurences(tc2));
    }

}