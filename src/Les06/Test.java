package Les06;

import java.util.Arrays;
import java.util.Random;

public class Test {
    static public BinNode<Integer> root = null;
    static Random rd = new Random();

    public static void main(String[] args) {
//        int[] pre = new int[]{17, 36, 12, 10, 42, 7, 28, 0, 1, 70};
//        int[] in = new int[]{10, 12, 42, 36, 17, 28, 7, 0, 1, 70};
//
//        System.out.println(Arrays.toString(pre));
//        System.out.println(Arrays.toString(in));

//        root = build(pre, in);
//        inOrder(root);
//        System.out.println();
//        preOrder(root);
//        System.out.println();


//       BinNode<Integer> root2 = new BinNode<>(17);
////        for (int i = 0; i < 10; i++) {
////            addToTree(root2,rd.nextInt(50));
////        }
////        System.out.print("PreOrder: ");
////        preOrder(root2);
////        System.out.println("");
////        System.out.print("InOrder: ");
////        inOrder(root2);


        int[] PreOrder = {17, 14, 31, 48, 24, 24, 38, 10, 24, 26, 24};
        int[] InOrder = {48, 31, 24, 14, 24, 17, 10, 24, 38, 24, 26};
        System.out.println(Arrays.toString(PreOrder));
        System.out.println(Arrays.toString(InOrder));

        root = build(PreOrder, InOrder);
        preOrder(root);
        System.out.println("");
        inOrder(root);
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

//        System.out.println("-------Left-------");
//        System.out.println(Arrays.toString(preLeft));
//        System.out.println(Arrays.toString(inLeft));
//
//        System.out.println("-------Right-------");
//        System.out.println(Arrays.toString(preRight));
//        System.out.println(Arrays.toString(inRight));

        node.setLeft(build(preLeft, inLeft));
        node.setRight(build(preRight, inRight));

        return node;

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