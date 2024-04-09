package Les01.L08.SummerExample;

import Les01.Node;

import java.util.Random;

public class Q1 {

    static Random rd = new Random();


    public static void main(String[] args) {
        Node<Integer> head = null;


        for (int i = 0, n = rd.nextInt(30); i < n; i++) {
            head = add(rd.nextInt(356), head);
        }

        printChain(head);

//        int max = findMaxFromChainRecursion(head);
//        printChain(head);
//        System.out.println(max);


        int max = findMaxFromChainIteration(head);
        printChain(head);
        System.out.println(max);

    }

    public static int findMaxFromChainIteration(Node<Integer> head) {
        if (head == null)
            return Integer.MIN_VALUE;

        int max = head.getValue();
        //method 1
        for (Node<Integer> i = head.getNext(); i != null; i = i.getNext()) {
            if (i.getValue() > max)
                max = i.getValue();
        }
        //method 2
//        while (head != null) {
//            if (head.getValue() > max)
//                max = head.getValue();
//            head = head.getNext();
//        }


        return max;

    }


    public static int findMaxFromChainRecursion(Node<Integer> head) {
        if (head == null)
            return Integer.MIN_VALUE;
        return Integer.max(head.getValue(), findMaxFromChainRecursion(head.getNext()));
    }

    private static Node<Integer> add(int value, Node<Integer> chain) {
        if (chain == null)
            return new Node(value);

        Node<Integer> temp = add(value, chain.getNext());
        chain.setNext(temp);
        return chain;
    }

    public static void printChain(Node<Integer> head) {

        while (head != null) {
            System.out.print(head.getValue() + " -> ");
            head = head.getNext();
        }
        System.out.println("null");

    }

    public static void balance(Node<Integer> chain) {
        if (chain == null)
            return;

        int counter = 0;
        int sum = 0;

        while (chain.hasNext()) {
            counter++;
            sum += chain.getValue();
            chain = chain.getNext();
        }
        counter++;
        sum += chain.getValue();

        if (counter % 2 != 0) {
            chain.setNext(new Node<>(-sum));
        } else if (sum != 0) {
            chain.setNext(new Node<>(-sum));
            chain = chain.getNext();
            chain.setNext(new Node<>(0));
        }
    }

}
