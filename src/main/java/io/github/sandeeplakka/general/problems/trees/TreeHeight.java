package io.github.sandeeplakka.general.problems.trees;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class TreeHeight {

    //Driver code
//    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.left.left = new Node(3);
//        root.left.left.left = new Node(4);
//
//        int height = findHeightV2(root);
//        System.out.println("height of tree : "+height);
//    }
    //Example
    /*
      1     1
    2   3   2
   4        3
   height = 3
     */

    //after writing the V1 code, Explained that I can write an optimized
    //solution by returning the Maximum height of its left and right child branches
    //That way, I don't need a Set and also time complexity reduces
    public int findHeightV2(Node node) {
        return findHRecV2(node, 0);
    }

    private int findHRecV2(Node node, int height) {
        if (node == null) return height;
        return Math.max(
                findHRecV2(node.left, height + 1),
                findHRecV2(node.right, height + 1)
        );
    }

    //written code in interview for a naive approach
    public int findHeightV1(Node node) {
        Set<Integer> heights = new HashSet<>();
        if (node == null) return 0;
        findHRecV1(node, 0, heights);
        return heights.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    private void findHRecV1(Node node, int height, Set<Integer> set) {
        if (node == null) {
            set.add(height);
            return;
        }
        findHRecV1(node.left, height + 1, set);
        findHRecV1(node.right, height + 1, set);
    }
}

//Node representation
class Node {
    int data;
    Node left;
    Node right;

    public int getData() {
        return data;
    }

    public Node(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
