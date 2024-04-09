package Les07;

import Les06.BinNode;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    private BinNode<Integer> root;
    private int size;

    public BST() {

        this.root = null;
        size = 0;
    }


    public boolean add(int e) {
        BinNode<Integer> newBinNode = new BinNode<>(e);
        ;
        if (root == null)
            root = newBinNode;
        else {
            BinNode<Integer> temp = root;

            while (temp != null) {
                if (e > temp.getValue()) {
                    if (!temp.hasRight()) {
                        temp.setRight(newBinNode);
                        break;
                    } else
                        temp = temp.getRight();
                } else {
                    if (!temp.hasLeft()) {
                        temp.setLeft(newBinNode);
                        break;
                    } else
                        temp = temp.getLeft();
                }
            }
        }

        return true;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(BinNode<Integer> root) {
        if (root == null)
            return;
        inOrder((root.getLeft()));
        System.out.print(" " + root.getValue());
        inOrder((root.getRight()));
    }

    private void levelOrder(BinNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinNode<Integer> temp = q.poll();
            System.out.print(temp.getValue() + " ");
            if (temp.hasLeft())
                q.add(temp.getLeft());

            if (temp.hasRight())
                q.add(temp.getRight());
        }
        System.out.println();
    }

    public void levelOrder() {
        levelOrder(root);
        System.out.println();
    }
}
