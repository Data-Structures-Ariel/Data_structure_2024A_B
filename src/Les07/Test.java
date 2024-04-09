package Les07;

import Les06.BinNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Test {
    static public BinNode<Integer> root = null;
    static Random rd = new Random();

    public static void main(String[] args) {


        int[] PreOrder = {17, 14, 31, 48, 24, 24, 38, 10, 24, 26, 24};
        int[] InOrder = {48, 31, 24, 14, 24, 17, 10, 24, 38, 24, 26};


        BinNode<Integer> root = build(PreOrder, InOrder);


        BST bst = new BST();


        bst.add(36);
        bst.add(35);
        bst.add(38);
        bst.add(12);
        bst.add(37);
        bst.add(65);
        bst.add(8);
        bst.add(58);
        bst.add(80);
        bst.add(11);
        bst.add(45);
        bst.add(68);
        bst.add(95);
        bst.add(78);
        bst.add(73);

        System.out.println();
        bst.inOrder();
        System.out.println("-----------------------");
        bst.levelOrder();


    }

    private static void levelOrder(BinNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinNode<Integer> temp = q.poll();
            System.out.print(temp.getValue() + " ");

            if (temp.hasLeft()) {
                q.add(temp.getLeft());
            }

            if (temp.hasRight()) {
                q.add(temp.getRight());
            }

        }
        System.out.println();
    }

    private static void inOrder(BinNode<Integer> root) {
        if (root == null)
            return;
        inOrder((root.getLeft()));
        System.out.print(" " + root.getValue());
        inOrder((root.getRight()));
    }

    private static void preOrder(BinNode<Integer> root) {

        if (root == null)
            return;
        System.out.print(" " + root.getValue());
        preOrder((root.getLeft()));
        preOrder((root.getRight()));
    }

    private static BinNode<Integer> build(int[] pre, int[] in) {
        if (pre.length != in.length || pre.length == 0)
            return null;
        if (pre.length == 1)
            return new BinNode<>(pre[0]);

        BinNode<Integer> node = new BinNode<>(pre[0]);

        int middle = pre[0];
        int i;
        for (i = 0; i < in.length; i++) {
            if (in[i] == middle)
                break;
        }
        int[] preLeft = Arrays.copyOfRange(pre, 1, i + 1);
        int[] inLeft = Arrays.copyOfRange(in, 0, i);

        int[] preRight = Arrays.copyOfRange(pre, i + 1, pre.length);
        int[] inRight = Arrays.copyOfRange(in, i + 1, in.length);

        node.setLeft(build(preLeft, inLeft));
        node.setRight(build(preRight, inRight));

        return node;

    }


}