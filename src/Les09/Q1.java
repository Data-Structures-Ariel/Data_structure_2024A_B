package Les09;


import java.util.LinkedList;
import java.util.Queue;

public class Q1 {

    public static void main(String[] args) {
//       q1();

        strangers(7, 21);

        Queue<Integer> queue = new LinkedList<>(){{
           int[] arr= {2, 10, 12, 3 ,7, 4, 1};
            for (int i = 0; i < arr.length; i++) {
                add(arr[i]);
            }
            }};
        System.out.println(queue);
        change(queue,9);
        System.out.println(queue);

    }

    private static void q1() {

        Queue<Integer> marks = new LinkedList<>() {{
            int[] grades = {80, 90, 100, -1, 75, 96, -1, 100, 100, 97, 96, -1, -1, 88, 94, -1};
            for (int i = 0; i < grades.length; i++) {

                add(grades[i]);
            }
        }};

        System.out.println(marks);
        Queue<Integer> tests = new LinkedList<>();

        int count = 0;
        int size = marks.size();
        for (int i = 0; i < size; i++) {


            if (marks.peek() != -1) {
                count++;
                marks.add(marks.poll());
            } else {
                tests.add(count);
                marks.poll();
                count = 0;
            }
        }

        System.out.println(marks);
        System.out.println(tests);
    }

    // m = q.size
    // n = max( i in [0,size] q[i])
    // O(m*n) ~ if n > m then O(n^2)
    public static void change(Queue<Integer> q, int num) {
        if (q == null || q.isEmpty())
            return;
        Queue<Integer> strangers = new LinkedList<>();
        Queue<Integer> nStrangers = new LinkedList<>();
        while (!q.isEmpty()) {
            if (strangers(q.peek(), num))
                strangers.add(q.poll());
            else
                nStrangers.add(q.poll());
        }
        while (!strangers.isEmpty())
            q.add(strangers.poll());

        while (!nStrangers.isEmpty())
            q.add(nStrangers.poll());
    }

    // n = Math.min(num1, num2);
    // O(n)
    public static boolean strangers(int num1, int num2) {

        int min = Math.min(num1, num2);

        for (int i = 2; i <= min; i++) {
            if (num1 % i == 0 && num2 % i == 0)
                return false;
        }
        return true;

    }
}