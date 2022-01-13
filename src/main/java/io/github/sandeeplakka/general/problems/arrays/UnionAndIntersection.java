package io.github.sandeeplakka.general.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionAndIntersection {

    private static void showCaseSamples(int[] a, int[] b, int[] union, int[] intersection) {
        UnionAndIntersection thisObj = new UnionAndIntersection();
        System.out.println(String.format("Arrays are following :%na : %s%nb : %s",
                Arrays.toString(a), Arrays.toString(b)));
        System.out.println("Union is : " + Arrays.toString(
                thisObj.findUnionOrIntersection(a, b, TYPE.UNION)) + " : Validation passed ? "
                + Arrays.equals(union, thisObj.findUnionOrIntersection(a, b, TYPE.UNION)));
        System.out.println("Intersection is : " + Arrays.toString(
                thisObj.findUnionOrIntersection(a, b, TYPE.INTERSECTION)) + " : Validation passed ? "
                + Arrays.equals(intersection, thisObj.findUnionOrIntersection(a, b, TYPE.INTERSECTION)));
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 2, 2, 3, 4, 5};
        int[] b = new int[]{1, 2, 2, 3, 3, 4, 5, 6, 7, 7, 8, 8, 8, 9};
        int[] unionRes = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] intersectionRes = new int[]{1, 2, 3, 4, 5};
        showCaseSamples(a, b, unionRes, intersectionRes);

        a = new int[]{1, 2, 2, 3, 4, 5};
        b = new int[]{1, 1, 3, 5};
        unionRes = new int[]{1, 2, 3, 4, 5};
        intersectionRes = new int[]{1, 3, 5};
        showCaseSamples(a, b, unionRes, intersectionRes);

        a = new int[]{1, 1, 1, 2, 2, 7, 9, 9};
        b = new int[]{1, 1, 3, 3, 7, 8, 8, 8};
        unionRes = new int[]{1, 2, 3, 7, 8, 9};
        intersectionRes = new int[]{1, 7};
        showCaseSamples(a, b, unionRes, intersectionRes);

        a = new int[]{};
        b = new int[]{};
        unionRes = new int[]{};
        intersectionRes = new int[]{};
        showCaseSamples(a, b, unionRes, intersectionRes);

        a = new int[]{};
        b = new int[]{1, 2, 2, 3};
        unionRes = new int[]{1, 2, 3};
        intersectionRes = new int[]{};
        showCaseSamples(a, b, unionRes, intersectionRes);

        a = new int[]{};
        b = new int[]{2, 3, 3, 4};
        unionRes = new int[]{2, 3, 4};
        intersectionRes = new int[]{};
        showCaseSamples(a, b, unionRes, intersectionRes);


    }

    enum TYPE {
        UNION,
        INTERSECTION;
    }

    public int[] findUnionOrIntersection(int[] a, int[] b, TYPE type) {
        int lastElem;
        int i = 0, j = 0;
        List<Integer> unionList = new ArrayList<>();
        List<Integer> intersectionList = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                lastElem = a[i];
                intersectionList.add(a[i]);
            } else if (a[i] < b[j]) {
                lastElem = a[i];
            } else {
                lastElem = b[j];
            }
            unionList.add(lastElem);
            while (i < a.length && a[i] == lastElem) i++;
            while (j < b.length && b[j] == lastElem) j++;
        }
        while (i < a.length) {
            lastElem = a[i];
            unionList.add(lastElem);
            while (i < a.length && a[i] == lastElem) i++;
        }
        while (j < b.length) {
            lastElem = b[j];
            unionList.add(lastElem);
            while (j < b.length && b[j] == lastElem) j++;
        }

        return (type == TYPE.UNION ? unionList.stream() :
                intersectionList.stream())
                .mapToInt(integer -> integer.intValue())
                .toArray();
    }


}
