package week2_warm_up;

public class FibonacciLastDigit {

    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    private static int getFibonacciLastDigitFast(int n) {
        if (n <= 1)
            return n;

        int[] lastDig = new int[n + 1];
        lastDig[0] = 0;
        lastDig[1] = 1;

        for (int i = 2; i < lastDig.length; i++) {
            lastDig[i] = (lastDig[i - 1] + lastDig[i - 2]) % 10;
        }

        return lastDig[n];
    }



    private static long getFibonacciLastDigitFast2(Long n) {

        long previous = 0;
        long current = 1;

        for (int i = 2; i < n + 1; i++) {
            long twoBefore = previous;
            long oneBefore = current;
            current = (oneBefore + twoBefore) % 10;
            previous = oneBefore;
        }
        return current;
    }


    public static void main(String[] args) {

//        System.out.println(getFibonacciLastDigitNaive(10));
//        System.out.println(getFibonacciLastDigitFast(10));
//        System.out.println(getFibonacciLastDigitFast(331));
//        System.out.println(getFibonacciLastDigitFast(327305));
//        System.out.println(getFibonacciLastDigitFast(999999));
    }

}
