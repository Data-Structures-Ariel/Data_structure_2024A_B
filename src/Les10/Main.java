package Les10;

import Les01.Node;

public class Main {

    public static void main(String[] args) {
        Node<Integer> chain = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4))));
        print(chain);
        first(chain);
        print(chain);

        Node<Integer> fiChain = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4))));
        print(fiChain);
        first(fiChain, 4);
        print(fiChain);

        Node<Integer> seChain = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4))));

        print(seChain);
        second(seChain);
        print(seChain);


        Node<Integer> tChain = new Node<>(1, new Node<>(2));

        print(tChain);
        second(tChain, 3);
        print(tChain);


        Node<Integer> thirdChain = new Node<>(3, new Node<>(1, new Node<>(5)));

        print(thirdChain);
        third(thirdChain);
        print(thirdChain);

    }

    // k = max(chain, chain.getNext()...chain.getNext().getNext())
    //O(k*n)
    private static void third(Node<Integer> chain) {
        while (chain != null) {
            for (int i = 0, k = chain.getValue(); i < k; i++) {
                Node<Integer> node = new Node<>(chain.getValue(), chain.getNext());
                chain.setNext(node);
                chain = chain.getNext();
            }
            chain = chain.getNext();
        }
    }


    //O(k*n)
    private static void second(Node<Integer> chain, int k) {

        if (chain == null)
            return;
        for (int i = 0; i < k; i++) {
            Node<Integer> head = new Node<>(chain.getValue());
            Node<Integer> temp = head;

            while (chain.hasNext()) {
                chain = chain.getNext();
                temp.setNext(new Node<>(chain.getValue()));
                temp = temp.getNext();
            }
            chain.setNext(head);
            chain = head;
        }


    }

    //O(n)
    private static void second(Node<Integer> chain) {
        if (chain == null)
            return;

        Node<Integer> head = new Node<>(chain.getValue());
        Node<Integer> temp = head;

        while (chain.hasNext()) {
            chain = chain.getNext();
            temp.setNext(new Node<>(chain.getValue()));
            temp = temp.getNext();
        }
        chain.setNext(head);

    }

    //O(n)
    // 1->2->3->4->null
    // 1->1->2->2->3->3->4->4->null
    public static void first(Node<Integer> chain) {

        while (chain != null) {
            Node<Integer> node = new Node<>(chain.getValue(), chain.getNext());
            chain.setNext(node);
            chain = node.getNext();
        }

    }

    //O(k*n)
    // if k=n then O(n^2)
    // if k=n*n then O(n^3)
    // (n*....*n) = m
    // if k=n*....*n O(n^m)
    public static void first(Node<Integer> chain, int k) {

        while (chain != null) {
            for (int i = 0; i < k; i++) {
                Node<Integer> node = new Node<>(chain.getValue(), chain.getNext());
                chain.setNext(node);
                chain = chain.getNext();
            }
            chain = chain.getNext();
        }

    }

    private static void print(Node<Integer> chain) {
        while (chain != null) {
            System.out.print(chain.getValue() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }

    private static void printWithAddress(Node<Integer> chain) {
        while (chain != null) {
            System.out.print("(" + chain + ") " + chain.getValue() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }


}
