package Les02;

public class MainNode {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        System.out.println("Head -> " + head);
        System.out.println("n2 -> " + n2);
        head.setNext(new Node<>(2));
        System.out.println("Head -> n2 -> null "+head);
//        n2.setNext(n3);
        head.getNext().setNext(n3);
        System.out.println("Head -> n2 -> n3 "+head);



        Node<Integer> n1 = new Node<>(1);
        System.out.println("n1 -> " + n1);

        n1.setNext(new Node<>(2));
        System.out.println("n1 -> " + n1);

        n1.getNext().setNext(new Node<>(3));
        System.out.println("n1 ->  "+n1);

        n1.getNext().getNext().setNext(new Node<>(4));

        Node<Integer> stam = n1.getNext();
        stam.getNext();
        n1.getNext().getNext();

        stam= stam.getNext();
        stam.getNext();
        n1.getNext().getNext().getNext();

        System.out.println("n1 ->  "+n1);



        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(5);
        ll.print();

        ll.add(6);
        ll.print();

        ll.add(4);
        ll.print();


        ll.add(5554);
        ll.print();


        LinkedListWithTail<Integer> ll1 = new LinkedListWithTail<>();

        ll1.add(5);
        ll1.print();

        ll1.add(6);
        ll1.print();

        ll1.add(4);
        ll1.print();


        ll1.add(5554);
        ll1.print();

    }
}
