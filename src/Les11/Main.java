package Les11;

import Les02.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Node<Integer> chain = new Node<>(2, new Node<>(1,
                new Node<>(2, new Node<>(1,
                        new Node<>(-4, new Node<>(1, new Node<>(0)))))));

        Queue<Integer> q = new LinkedList<>() {{
            add(2);
            add(10);
            add(12);
            add(3);
            add(7);
            add(4);
            add(1);
        }};

        System.out.println(q);
        System.out.println(putInPlace(q, 9));
        System.out.println(q);


        Queue<Integer> q1 = new LinkedList<>() {{
            add(7);
            add(2);
            add(5);
            add(4);
            add(6);
            add(8);
            add(10);
            add(12);
        }};

        System.out.println(q1);
        moveToFront(q1,5);
        System.out.println(q1);
    }

    public int numNodesFollowing(Node<Integer> chain) {
        if (chain == null)
            return 0;

        int count = 0;

        while ((chain = chain.getNext()) != null)
            count++;

        return count;
    }

    public boolean isSection(Node<Integer> chain) {
        if (chain == null)
            return true;

        while (chain != null) {
            if (chain.getValue() > numNodesFollowing(chain))
                return false;
            chain = chain.getNext();
        }
        return true;
    }

    //O(n)
    public static void balance(Node<Integer> chain) {
        if (chain == null)
            return;

        int count = 1;
        int sum = 0;
        while (chain.hasNext()) {
            count++;
            sum += chain.getValue();
            chain = chain.getNext();
        }

        if (count % 2 != 0)
            chain.setNext(new Node<>(-sum));
        else if (sum != 0)
            chain.setNext(new Node<>(-sum, new Node<>(0)));

    }

    public static int putInPlace(Queue<Integer> q, int num) {
        if (q == null)
            return -1;

        Queue<Integer> big = new LinkedList<>();
        Queue<Integer> small = new LinkedList<>();

        int count = 0;

        while (!q.isEmpty()) {
            if (q.peek() <= num) {
                small.add(q.remove());
                count++;
            } else big.add(q.remove());
        }

        while (!small.isEmpty())
            q.add(small.remove());
        q.add(num);
        while (!big.isEmpty())
            q.add(big.remove());

        return count + 1;
    }

    public static void moveToFront(Queue<Integer> q, int k) {
        if (q == null || q.isEmpty() || k < 0)
            return;

        Queue<Integer> temp = new LinkedList<>();
        int size = 0;
        while (!q.isEmpty()) {
            temp.add(q.remove());
            size++;
        }

        while (!temp.isEmpty())
            q.add(temp.remove());

        for (int i = 0; i < size - k; i++)
            q.add(q.remove());

    }

}
