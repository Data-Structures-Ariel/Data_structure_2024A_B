package Les01.L04.Generics;

public class TestGen {

    public static void main(String[] args) {

        int a = 9, b = 10;
        float a1 = 9.5f, b1 = 10.5f;


        int ans = sum(a, b);

        float ans1 = sum(a1, b1);
//        sum(5.5,5.6);
//         sum(5,5);

    }

    private static int sum(int a, int b) {
        return a + b;
    }
    private static float sum(float a, float b) {
        return a + b;
    }
}
