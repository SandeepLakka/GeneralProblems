package io.github.sandeeplakka.general.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountNumberOfOccurrences {


    /**
     * Returns the number of times string <b>sub</b> occurs in string <b>string</b>
     *
     * @param string Input string in which to find the occurences of substring
     * @param sub    substring which needs to be searched in above string
     * @return count of occurrences of sub present in string, -1 if no match exists
     * Note : Overlapping substrings are not considered.
     * e.g : occurrences of substring "ee" in string "heee yaaa" will be 1 not 2.
     */
    public int getCountOfOccurences(String string, String sub) {
        if (string == null || sub == null) {
            throw new IllegalArgumentException("Input string or substring must not be null");
        }
        if (string.indexOf(sub) == -1) {
            return -1;
        }

        Matcher matcher = Pattern.compile(sub).matcher(string);//.groupCount();
        int cnt = 0;
        while (matcher.find()) {
            cnt++;
        }
        return cnt;
    }
}
