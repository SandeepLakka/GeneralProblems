package io.github.sandeeplakka.general.problems;

import java.util.Arrays;

public class ReverseNumber {


//    private static final ReverseNumber self = new ReverseNumber();
//
//    public static void main(String[] args) {
//        int[] numbers = {123456, -980, 24608};
//        Arrays.stream(numbers).boxed().forEach(number ->
//                System.out.println("Number " + number
//                        + " reversed becomes : "
//                        + self.getReversedNumber(number))
//        );
//    }

    // This implementation is done without using any libraries

    /**
     * Return number with all digits positions reversed.
     * e.g: (-)123 will be converted to (-)321
     *
     * @param number Integer number
     * @return Number with digits positions reversed
     */
    public int getReversedNumber(int number) {
        int result = 0;
        while (number != 0) {
            result = result * 10 + number % 10;
            number /= 10;
        }
        return result;
    }

}
