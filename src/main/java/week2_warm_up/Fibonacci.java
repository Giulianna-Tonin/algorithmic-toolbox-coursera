package week2_warm_up;

import java.util.HashMap;
import java.util.Random;

public class Fibonacci {

    //naive
    private static long calc_fib(int n) {
        if (n <= 1)
            return n;

        return calc_fib(n - 1) + calc_fib(n - 2);
    }

    //memoization
    private static final HashMap<Integer, Long> memo = new HashMap<>();

    private static long calc_fib_memoization(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long result = calc_fib_memoization(n - 1) + calc_fib_memoization(n - 2);
        memo.put(n, result);
        return result;
    }

    //interative
    private static long calc_fib_fast(int n) {
        if (n <= 1) {
            return n;
        }

        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    //another way
    private static int getFibonacciNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current;
    }

    public static void main(String[] args) {

        // stress test
        while (true) {
            Random rd = new Random();
            int n = rd.nextInt(10);

            long resp1 = calc_fib(n);
            long resp2 = calc_fib_fast(n);
            long resp3 = calc_fib_memoization(n);

            if (resp1 == resp2) {
                System.out.println("OK " + resp1);
            } else {
                System.out.println("Wrong answer - " + resp1 + " " + resp2);
                break;
            }

            if (resp1 == resp3) {
                System.out.println("OK " + resp3);
            } else {
                System.out.println("Wrong answer - " + resp1 + " " + resp3);
                break;
            }
        }
    }
}
