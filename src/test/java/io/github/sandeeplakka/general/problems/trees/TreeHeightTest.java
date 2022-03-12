package io.github.sandeeplakka.general.problems.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeHeightTest {
    private TreeHeight underTest;

    @BeforeEach
    public void init() {
        underTest = new TreeHeight();
    }

    @RepeatedTest(10)
    void test_findHeightV2() {

        int height = (int) Math.floor(Math.random() * 20);
        System.out.println("Checking for a tree of height " + height);
        assertEquals(height, underTest.findHeightV2(getTreeOfHeight(height)), "Height should be " + height);

        height = (int) Math.floor(Math.random() * 100);
        System.out.println("Checking for a tree of height " + height);
        assertEquals(height, underTest.findHeightV2(getTreeOfHeight(height)), "Height should be " + height);
    }

    @RepeatedTest(10)
    void test_findHeightV1() {
        int height = (int) Math.floor(Math.random() * 20);
        System.out.println("Checking for a tree of height " + height);
        assertEquals(height, underTest.findHeightV1(getTreeOfHeight(height)), "Height should be " + height);

        height = (int) Math.floor(Math.random() * 100);
        System.out.println("Checking for a tree of height " + height);
        assertEquals(height, underTest.findHeightV1(getTreeOfHeight(height)), "Height should be " + height);
    }

//    @Test
//    void debug_getTreeOfHeight(){
//        Node node = getTreeOfHeight(10);
//        Node temp = node;
//        int idx = 0;
//        while (temp != null){
//            if(idx == 0) System.out.print("Root\t: ");
//            System.out.println(++idx +" : " +temp.getData());
//            boolean isLeft = temp.left != null ? true : false;
//            System.out.print(isLeft ? "Left\t: " : temp.right != null ? "Right\t: " : "End");
//            temp = isLeft ? temp.left : temp.right;
//        }
//    }

    //Helper
    private Node getTreeOfHeight(int height) {
        if (height == 0) return null;
        int val = 1;
        Node root = new Node(1);
        height--;
        Node pointer = root;
        while (height > 0) {
            boolean isLeft = Math.random() * 10 > 5;
            if (isLeft) {
                pointer.left = new Node(++val);
                pointer = pointer.left;
            } else {
                pointer.right = new Node(++val);
                pointer = pointer.right;
            }
            height--;
        }
        return root;
    }
}