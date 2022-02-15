package io.github.sandeeplakka.general.problems.bits;

public class SetBitsFinder {

    public int findSetBits(int number) {
        int res = 0;
        while (number != 0) {
            number &= (number - 1);
            res++;
        }
        return res;
    }
}
