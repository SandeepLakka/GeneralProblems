package io.github.sandeeplakka.general.problems.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionAndIntersectionTest {

    UnionAndIntersection unionAndIntersection;

    @BeforeEach
    public void init() {
        unionAndIntersection = new UnionAndIntersection();
    }

    @Test
    @DisplayName("Test all unions")
    void testUnions() {
        int[] a = new int[]{1, 1, 2, 2, 2, 3, 4, 5};
        int[] b = new int[]{1, 2, 2, 3, 3, 4, 5, 6, 7, 7, 8, 8, 8, 9};
        int[] unionRes = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(unionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.UNION));

        a = new int[]{1, 2, 2, 3, 4, 5};
        b = new int[]{1, 1, 3, 5};
        unionRes = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(unionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.UNION));

        a = new int[]{1, 1, 1, 2, 2, 7, 9, 9};
        b = new int[]{1, 1, 3, 3, 7, 8, 8, 8};
        unionRes = new int[]{1, 2, 3, 7, 8, 9};
        assertArrayEquals(unionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.UNION));

        a = new int[]{};
        b = new int[]{};
        unionRes = new int[]{};
        assertArrayEquals(unionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.UNION));


        a = new int[]{};
        b = new int[]{1, 2, 2, 3};
        unionRes = new int[]{1, 2, 3};
        assertArrayEquals(unionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.UNION));


        a = new int[]{};
        b = new int[]{2, 3, 3, 4};
        unionRes = new int[]{2, 3, 4};
        assertArrayEquals(unionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.UNION));

    }


    @Test
    @DisplayName("Test all intersections")
    public void testIntersections() {
        int[] a = new int[]{1, 1, 2, 2, 2, 3, 4, 5};
        int[] b = new int[]{1, 2, 2, 3, 3, 4, 5, 6, 7, 7, 8, 8, 8, 9};
        int[] intersectionRes = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(intersectionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.INTERSECTION));


        a = new int[]{1, 2, 2, 3, 4, 5};
        b = new int[]{1, 1, 3, 5};
        intersectionRes = new int[]{1, 3, 5};
        assertArrayEquals(intersectionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.INTERSECTION));


        a = new int[]{1, 1, 1, 2, 2, 7, 9, 9};
        b = new int[]{1, 1, 3, 3, 7, 8, 8, 8};
        intersectionRes = new int[]{1, 7};
        assertArrayEquals(intersectionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.INTERSECTION));

        a = new int[]{};
        b = new int[]{};
        intersectionRes = new int[]{};
        assertArrayEquals(intersectionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.INTERSECTION));

        a = new int[]{};
        b = new int[]{1, 2, 2, 3};
        intersectionRes = new int[]{};
        assertArrayEquals(intersectionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.INTERSECTION));

        a = new int[]{};
        b = new int[]{2, 3, 3, 4};
        intersectionRes = new int[]{};
        assertArrayEquals(intersectionRes, unionAndIntersection.findUnionOrIntersection(a, b, UnionAndIntersection.TYPE.INTERSECTION));

    }
}