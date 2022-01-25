package io.github.sandeeplakka.general.problems;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OccurencesOfEachCharInString {

    //To mimic the behavior of Predicated.not of JDK11
    public static <T> Predicate<T> not(Predicate<T> t) {
        return t.negate();
    }

//    private final static OccurencesOfEachCharInString self = new OccurencesOfEachCharInString();
//    public static void main(String[] args) {
//
//        String input = self.getClass().getSimpleName();
//        System.out.println("characters count in "+input+" is : "+self.getCountOfOccurences(input));
//
//        input = "hello bye";
//        System.out.println("characters count in "+input+" is : "+self.getCountOfOccurences(input));
//
//    }

    /**
     * Returns the number of occurences of each distinct character in a given string
     *
     * @param input Input String
     * @return Map with key as character and value as count of occurences of it
     * in the input
     */
    public Map<Character, Integer> getCountOfOccurences(String input) {

        return input.chars().distinct().mapToObj(value -> (char) value)
                .filter(not(Character::isSpaceChar))
                .collect(Collectors.toMap(
                        character -> character,
                        character -> (input.length() -
                                input.replaceAll(String.valueOf(character),"").length()))
                );
    }

}
