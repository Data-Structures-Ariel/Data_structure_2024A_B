package Les05;

import Les01.Node;

import java.util.Random;

public class BinaryTree {

    static Random rd = new Random();

    public static void main(String[] args) {
        // level 0
        BinNode<Integer> root = new BinNode<>(17);

        // Level 1
        root.setLeft(new BinNode<>(36));
        root.setRight(new BinNode<>(7));

        // Level 2
        root.getLeft().setLeft(new BinNode<>(12));

        root.getRight().setLeft(new BinNode<>(28));
        root.getRight().setRight(new BinNode<>(0));

        // Level 3
        root.getLeft().getLeft().setRight(new BinNode<>(42));
        root.getLeft().getLeft().setLeft(new BinNode<>(10));

        root.getRight().getRight().setRight(new BinNode<>(1));

        // Level 4

        root.getRight().getRight().getRight().setRight(new BinNode<>(70));


        inOrder(root);
        System.out.println("");
        int count = countNode(root);
        System.out.println(" ");
        System.out.println(count);
        addToTree(root, 80);

        inOrder(root);


        count = countNode(root);
        System.out.println(" ");
        System.out.println(count);


    }

    private static int countNode(BinNode<Integer> root) {
        if (root == null)
            return 0;
        return countNode(root.getLeft()) + countNode(root.getRight())+ 1;
    }

    private static void inOrder(BinNode<Integer> root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrder(root.getRight());
        }
    }

    private static void addToTree(BinNode<Integer> root, int num) {

        if (root == null)
            return;

        while (root != null) {
            int c = rd.nextInt(2);
            if (c == 1) {
                if (root.hasRight())
                    root = root.getRight();
                else {
                    root.setRight(new BinNode<>(num));
                    break;
                }
            } else {
                if (root.hasLeft())
                    root = root.getLeft();
                else {
                    root.setLeft(new BinNode<>(num));
                    break;
                }
            }


        }


    }


}
