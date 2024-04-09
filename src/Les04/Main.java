package Les04;


public class Main {

    public static void main(String[] args) {
        Node<Integer> chain = new Node<>(5);
        chain.setNext(new Node<>(20));
        chain.getNext().setNext(new Node<>(9));
        chain.getNext().getNext().setNext(new Node<>(6));
        chain.getNext().getNext().getNext().setNext(new Node<>(5));
        chain.getNext().getNext().getNext().getNext().setNext(new Node<>(8));
        chain.getNext().getNext().getNext().getNext().getNext().setNext(new Node<>(2));

        print(chain);
        Node<Integer> diffChain = differenceList(chain);
        print(diffChain);
        print(chain);

        int survives = theSurvives(chain);
        System.out.println(survives);

        chain = new Node<>(1);
        chain.setNext(new Node<>(1));
        chain.getNext().setNext(new Node<>(2));
        chain.getNext().getNext().setNext(new Node<>(4));
        chain.getNext().getNext().getNext().setNext(new Node<>(8));
        chain.getNext().getNext().getNext().getNext().setNext(new Node<>(16));
        chain.getNext().getNext().getNext().getNext().getNext().setNext(new Node<>(32));

        print(chain);

        boolean bool = chainSum(chain);
        System.out.println(bool);


        chain = new Node<>(8);
        chain.setNext(new Node<>(8));
        chain.getNext().setNext(new Node<>(16));
        chain.getNext().getNext().setNext(new Node<>(32));
        chain.getNext().getNext().getNext().setNext(new Node<>(64));
        chain.getNext().getNext().getNext().getNext().setNext(new Node<>(128));
        chain.getNext().getNext().getNext().getNext().getNext().setNext(new Node<>(256));


        bool = chainSum(chain);
        System.out.println(bool);

        chain = new Node<>(8);
        chain.setNext(new Node<>(-1));
        chain.getNext().setNext(new Node<>(16));
        chain.getNext().getNext().setNext(new Node<>(32));
        chain.getNext().getNext().getNext().setNext(new Node<>(64));
        chain.getNext().getNext().getNext().getNext().setNext(new Node<>(128));
        chain.getNext().getNext().getNext().getNext().getNext().setNext(new Node<>(256));


        bool = chainSum(chain);
        System.out.println(bool);

        chain = new Node<>(64);
        chain.setNext(new Node<>(32));
        chain.getNext().setNext(new Node<>(16));
        chain.getNext().getNext().setNext(new Node<>(8));
        chain.getNext().getNext().getNext().setNext(new Node<>(4));
        chain.getNext().getNext().getNext().getNext().setNext(new Node<>(2));
        chain.getNext().getNext().getNext().getNext().getNext().setNext(new Node<>(2));


        print(chain);
        bool = reversChainSum(chain);
        System.out.println(bool);

        print(chain);
        bool = reversChainSumRec(chain);
        System.out.println(bool);


    }

    private static boolean chainSum(Node<Integer> chain) {

        if (chain == null)
            return false;

        int sum = chain.getValue();

        while ((chain = chain.getNext()) != null) {
            if (chain.getValue() != sum)
                return false;
            sum += chain.getValue();
        }

        return true;
    }

    private static boolean reversChainSum(Node<Integer> chain) {

        if (chain == null)
            return false;

        int sum = chain.getValue();

        while ((chain = chain.getNext()) != null && chain.hasNext()) {
            int currentValue = chain.getValue();
            if (sum - currentValue != currentValue)
                return false;
            sum -= chain.getValue();
        }

        return true;
    }


    public static boolean reversChainSumRec(Node<Integer> chain) {

        return reversChainSumRecP(chain.getNext()) == chain.getValue();
    }

    private static int reversChainSumRecP(Node<Integer> chain) {

        if (chain == null)
            return 0;
        if (chain.hasNext())
            return reversChainSumRecP(chain.getNext()) + chain.getValue();

        return chain.getValue();
    }

    private static int theSurvives(Node<Integer> chain) {
        if (chain == null)
            return -1;

        print(chain);
        Node<Integer> temp = differenceList(chain);

        while (temp.hasNext()) {
            print(temp);
            temp = differenceList(temp);
        }
        return temp.getValue();
    }

    private static Node<Integer> differenceList(Node<Integer> chain) {

        if (chain == null || !chain.hasNext())
            return null;

        Node<Integer> headDiff = new Node<>(Math.abs(chain.getValue() - chain.getNext().getValue()));
        Node<Integer> tempDiff = headDiff;
        chain = chain.getNext();

        while (chain.hasNext()) {
            Node<Integer> newNode = new Node<>(Math.abs(chain.getValue() - chain.getNext().getValue()));
            tempDiff.setNext(newNode);
            tempDiff = tempDiff.getNext();
            chain = chain.getNext();
        }
        return headDiff;
    }

    private static void print(Node<Integer> chain) {
        if (chain == null)
            return;
        while (chain != null) {
            System.out.print(chain.getValue() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }


    static public class Node<T> {

        private T value;
        private Node<T> next;


        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;

        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }


        public boolean hasNext() {
            return next != null;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

}
