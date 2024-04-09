package Les01.L07;

import java.util.*;

public class TestQueue {


    public static void main(String[] args) {

        Queue<Integer> q = new Queue<Integer>() {
            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean offer(Integer integer) {
                return false;
            }

            @Override
            public Integer remove() {
                return null;
            }

            @Override
            public Integer poll() {
                return null;
            }

            @Override
            public Integer element() {
                return null;
            }

            @Override
            public Integer peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };

        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            qu.add(i);
        }
        // <-  poll {0,1,2,3,4,5,6,7,8,9} <- insert
        System.out.println(qu);
        // remove one element
        System.out.println("one poll -> " + qu.poll());
        // <-  poll {1,2,3,4,5,6,7,8,9} <- insert
        System.out.println(qu);
        System.out.println("second poll -> " + qu.poll());
        // <-  poll {2,3,4,5,6,7,8,9} <- insert
        System.out.println(qu);
        System.out.println("peek -> " + qu.peek());
        // <-  poll {2,3,4,5,6,7,8,9} <- insert
        System.out.println(qu);
        System.out.println("isEmpty -> " + qu.isEmpty());
        while (!qu.isEmpty())
            qu.poll();
        System.out.println(qu);
        System.out.println("isEmpty -> " + qu.isEmpty());

        qu.poll();
        try {
            qu.remove();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }


        Queue<Integer> qTemp = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            qTemp.add(i);
        }

        System.out.println("------------------------------");
        System.out.println("Before - > " + qTemp);
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            qTemp.add(qTemp.poll());
            System.out.println("iter -> " + i + " Q => " + qTemp);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < 6; i++) {
            queue.add(i);
        }


        //{1,2,3,4,5}
        // k=6
        //count =0;
        //i = 0
        //{2,3,4,5,1} count =1
        //{3,4,5,1,2} count=2
        //{4,5,1,2,3} count=3
        //{5,1,2,3,4} count=4
        //{1,2,3,4,5} count=5
        //{2,3,4,5} count=6

        //i = 0
        // count=0
        //{3,4,5,2} count=1
        //{4,5,2,3} count=2
        //{5,2,3,4} count=3
        //{2,3,4,5} count=4
        //{3,4,5,2} count=5
        //{4,5,2} count=6
        // .
        // .
        // .
        //i = 5
        // count=0
        //{3}


        System.out.println("------------------------------------");
        System.out.println(queue);
        int sizeQ = size(queue);
        System.out.println("Size queue -> " + sizeQ);
        int k = new Random().nextInt(50);
        System.out.println("K -> " + k);
        int kValue = removeKValue(k, queue);
        System.out.println("K-value from qu is -> " + kValue);

        int[] gradeArr = {80, 90, 100, -1, 75, 96, -1, 100, 100, 97, 96, -1, -1, 88, 94, -1};
        Queue<Integer> grades = new LinkedList<>();
        for (int i = 0; i < gradeArr.length; i++)
            grades.add(gradeArr[i]);

        System.out.println(grades);
        Queue<Integer> marks = arrangeData(grades);

        System.out.println(grades);
        System.out.println(marks);

    }

    // בבית תנסו לפתור ללא תור עזר וללא זקיף ספירה
    // 2n+5 -> O(n)
    private static Queue<Integer> arrangeData(Queue<Integer> grades) {
        // O(2)
        if (grades == null || grades.isEmpty())
            return null;
        //O(3)
        Queue<Integer> marks = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        int count = 0;

        //O(n)
        while (!grades.isEmpty()) {
            if (grades.peek() != -1) {
                count++;
                temp.add(grades.poll());
            } else {
                grades.poll();
                marks.add(count);
                count = 0;
            }
        }

        //O(n)
        while (!temp.isEmpty())
            grades.add(temp.poll());

        return marks;
    }

    //O(n*k) n -> size o queue, k random integer
    private static int removeKValue(int k, Queue<Integer> qu) {
        //O(1)
        if (qu == null || qu.isEmpty() || k < 1)
            return Integer.MAX_VALUE;
        int item = -1;
        //O(n)
        while (!qu.isEmpty()) {
            //O(k)
            for (int i = 0; i < k; i++) {
                qu.add(qu.poll());
            }
            item = qu.poll();
        }


        return item;
    }

    //2n+4 -> O(n)
    private static int size(Queue<Integer> qu) {
        if (qu == null || qu.isEmpty())
            return 0;

        Queue<Integer> temp = new LinkedList<>();
        int count = 0;
        while (!qu.isEmpty()) {
            count++;
            temp.add(qu.poll());
        }

        while (!temp.isEmpty())
            qu.add(temp.poll());
        return count;
    }
}
