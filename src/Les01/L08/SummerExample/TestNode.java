package Les01.L08.SummerExample;

import Les01.Node;

public class TestNode {

    public static void main(String[] args) {



        Node<Integer> head = new Node<>(0);
        System.out.println(head.getValue());
        System.out.println(head.getNext());
        System.out.println(head);

//        Node<Integer> head2 = new Node<>(1,null);
//        System.out.println(head2.getValue());
//        System.out.println(head2.getNext());
//        System.out.println(head2.toString());

//        head.setNext(head2);
//        head2.setNext(new Node(2));

        head.setNext(new Node<>(1, null));
        head.getNext().setNext(new Node(2));
        head.getNext().getNext().setNext(new Node(3));


        System.out.println(head.toString());


        printChain(head);


        Node<Integer> n0 = new Node<>(0);
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n7 = new Node<>(7);
        Node<Integer> n8 = new Node<>(8);
        Node<Integer> n9 = new Node<>(9);


        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n9);


        printChain(n0);


        n0.setNext(n1);
        n0.getNext().setNext(n2);
        n0.getNext().getNext().setNext(n3);
        n0.getNext().getNext().getNext().setNext(n4);
        n0.getNext().getNext().getNext().getNext().setNext(n5);
        n0.getNext().getNext().getNext().getNext().getNext().setNext(n6);
        n0.getNext().getNext().getNext().getNext().getNext().getNext().setNext(n7);
        n0.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(n8);
        n0.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(n9);

        printChain(n0);


        n0.setNext(new Node(1));
        n0.getNext().setNext(new Node(2));
        n0.getNext().getNext().setNext(new Node(3));
        n0.getNext().getNext().getNext().setNext(new Node(4));
        n0.getNext().getNext().getNext().getNext().setNext(new Node(5));
        n0.getNext().getNext().getNext().getNext().getNext().setNext(new Node(6));
        n0.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(7));
        n0.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(8));
        n0.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(9));

        printChain(n0);

        Node<Integer> node;
        Node<Integer> temp;

        node = new Node<>(0);
        temp = node;
        for (int i = 1; i < 10; i++) {
            temp.setNext(new Node<>(i));
            temp = temp.getNext();
        }

        printChain(node);
//      n0.setNext((new Node(1).setNext(new Node(2))));


        Node<Integer> chain = new Node<>(0);
        add(chain, 1);
        printChain(chain);

        for (int i = 2; i < 10; i++) {
            add(chain, i);
        }
        printChain(chain);

        Node<Integer> chain2 = add(10, null);
        chain2 = add(20, chain2);
        printChain(chain2);


        for (int i = 30; i < 100 ; i+=10) {
            add(i,chain2);
        }
        printChain(chain2);


    }

    //O(n)
    private static void add(Node<Integer> chain, int value) {
        if (chain == null)
            return;
        if (chain.getNext() != null)
            add(chain.getNext(), value);
        else
            chain.setNext(new Node<>(value));
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
}


