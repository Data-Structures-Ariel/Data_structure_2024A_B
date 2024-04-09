package Les03;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.add(1);

        Node<Integer> chain = null;
        boolean bool = test(chain);
    }

    private static boolean test(Node<Integer> chain) {
        if (chain == null)
            return false;

        int sum = chain.getValue();
        chain = chain.getNext();
        while (chain != null) {
            int currentValue = chain.getValue();
            if (currentValue != sum)
                return false;

            sum += currentValue;
            chain = chain.getNext();

        }

        return true;
    }


}
