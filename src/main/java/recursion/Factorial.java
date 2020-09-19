package recursion;

public class Factorial {

    //n! = n.(n-1).(n-2).(n-3).(n-4)....(2.1)
    //5! = 5.(5-1).(5-2).(5-3).(5-4)
    //5! = 5.4.3.2.1 = 120

    private static int calcIterativeFactorial(int n) {
        int result = 1;

        for (int i = 0; i <= n - 1; i++) {
            result *= (n - i);
        }
        return result;
    }

    private static int calcRecursiveFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * calcRecursiveFactorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(calcIterativeFactorial(5));
        System.out.println(calcIterativeFactorial(6));
        System.out.println(calcIterativeFactorial(0));
        System.out.println(calcRecursiveFactorial(5));
        System.out.println(calcRecursiveFactorial(6));
        System.out.println(calcRecursiveFactorial(0));
    }
}
