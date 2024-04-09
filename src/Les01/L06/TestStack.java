package Les01.L06;

import java.util.Stack;

public class TestStack {


    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 10; i++) {
            st.push(i);
        }

        Stack<Integer> st1 = new Stack<>() {{
            for (int i = 0; i < 10; i++) {
                add(i);
            }
        }};

        System.out.println("--- Print stack ---");
        System.out.println(st);
        System.out.println(st1);

        System.out.println("--Pop element from stack ");
        int num1 = st.pop();
        int num2 = st1.pop();

        System.out.println("Print num1 and num2 2 after pop");

        System.out.println(num1);
        System.out.println(num2);

        System.out.println(st);
        System.out.println(st1);
        num1 = st.peek();
        num2 = st1.peek();

        System.out.println("Print num1 and num2 2 after peek");
        System.out.println(num1);
        System.out.println(num2);

        System.out.println(st);
        System.out.println(st1);

        // 1. )()()(
        // 2. (()())
        // 3. ())
        // 4. (((()))

        System.out.println("-----------------------------------");
        boolean bool = checkEq("(()))()()()()())");
        System.out.println(bool);
        bool = checkEq(")()()(");
        System.out.println(bool);
        bool = checkEq("(()())");
        System.out.println(bool);
        bool = checkEq("())");
        System.out.println(bool);
        bool = checkEq("(((()))");
        System.out.println(bool);
        bool = checkEq("");
        System.out.println(bool);
        bool = checkEq(null);
        System.out.println(bool);
        System.out.println("-----------------------------------");


        myStackArray<Integer> mySt = new myStackArray<>();
        for (int i = 0; i < 8; i++) {
            mySt.push(i);
        }
        System.out.println(mySt);
        for (int i = 0; i < 3; i++) {
            System.out.println(mySt.pop());
        }
        System.out.println(mySt);
        // with Exception
        for (int i = 0; i < 6; i++) {
            try {
                mySt.push(i);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error");
            }
        }
        // without Exception
//        for (int i = 0; i < 6; i++) {
//            mySt.push(i);
//        }
        System.out.println(mySt);
        for (int i = 0; i < 11; i++) {
            try {
                System.out.println(mySt.pop());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error pop");
            }
        }

    }

    private static boolean checkEq(String s) {
        if (s == null || s.isEmpty())
            return true;
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> temp = new Stack<>();
        // 1. )()()(
        // 2. (()())
        // 3. ())
        // 4. (((()))

        for (int i = 0, size = s.length(); i < size; i++) {

            if (s.charAt(i) == '(')
                temp.add('(');
            else if (s.charAt(i) == ')' && !temp.isEmpty())
                temp.pop();
            else {
                return false;
            }
        }

        return temp.isEmpty();


    }


}
