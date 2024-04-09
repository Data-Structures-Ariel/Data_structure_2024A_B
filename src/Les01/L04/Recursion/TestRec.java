package Les01.L04.Recursion;


import java.util.Arrays;

public class TestRec {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        int n = 10;
        int exp = 2;
        int a, b;
        a = b = 6;

        int ans = sum(n);
        System.out.print(ANSI_BLUE);
        System.out.println(ans);

        ans = mul(a, b);
        System.out.println(ans);

        ans = pow(n, exp);
        System.out.println(ans);

        ans = factorial(n);
        System.out.println(ans);

        int[] arr = {10, 20, 30, 55, 78, 94, 105, 125, 187};
        int value = 78;

        System.out.println(Arrays.toString(arr));
        boolean bool = linearSearchRec(arr, value);
        System.out.println(bool);

        System.out.print(ANSI_PURPLE);
        System.out.println(Arrays.toString(arr));
        bool = linearSearchRec(arr, 545);
        System.out.println(bool);

        bool = binarySearchRec(arr, value);
        System.out.println(bool);


        bool = binarySearchRec(arr, 545);
        System.out.println(bool);



    }

    private static boolean binarySearchRec(int[] arr, int value) {
        if (arr.length == 0)
            return false;
        int mid = arr.length / 2;
        if (arr[mid] == value)
            return true;
        else if (arr[mid] < value)
            return binarySearchRec(Arrays.copyOfRange(arr, mid + 1, arr.length), value);
        else
            return binarySearchRec(Arrays.copyOfRange(arr, 0, mid), value);
    }

    private static boolean linearSearchRec(int[] arr, int value) {
        if (arr.length == 0)
            return false;
        if (arr[0] == value)
            return true;

        int[] a = Arrays.copyOfRange(arr, 1, arr.length);
        System.out.println(Arrays.toString(a));

        return linearSearchRec(a, value);
    }

    // n=2, exp=4 => ans= 2*2*2*2
    private static int pow(int n, int exp) {
        if (exp == 0)
            return 1;
        return n * pow(n, exp - 1);
    }

    // n = 10 => ans = 1*2*3*4*5*6*7*8*9*10=3,628,800
    private static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    //1. a=7, b=5 => ans = 5*5*5*5*5*5*5
    //2. a=7, b=5 => ans = 7*7*7*7*7
    //6+6+6+6+6+
    private static int mul(int a, int b) {
        if (a == 0)
            return 0;
        return b + mul(a - 1, b);
    }

    // n = 10 => ans = 1+2+3+4+5+6+7+8+9+10=55
    private static int sum(int n) {
        if (n == 0)
            return 0;
        return n + sum(n - 1);
    }
}
