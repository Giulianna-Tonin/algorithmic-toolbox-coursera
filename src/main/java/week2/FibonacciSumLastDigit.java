package week2;

import java.util.Random;

public class FibonacciSumLastDigit {

    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }


    private static long getFibonacciSumFast(long n) {
        if (n <= 1)
            return n;
        if(n <= 60){
            return getFibonacciSumNaive(n);
        } else {
            return getFibonacciSumNaive(n%60);
        }
    }


    public static void main(String[] args) {

        System.out.println(assertEquals(getFibonacciSumFast(9999999999999L),0));
        System.out.println(assertEquals(getFibonacciSumFast(0), 0));
        System.out.println(assertEquals(getFibonacciSumFast(1), 1));
        System.out.println(assertEquals(getFibonacciSumFast(2), 2));
        System.out.println(assertEquals(getFibonacciSumFast(62), 2));
        System.out.println(assertEquals(getFibonacciSumFast(60), 0));
        System.out.println(assertEquals(getFibonacciSumFast(122), 2));
        System.out.println(assertEquals(getFibonacciSumFast(182), 2));
        System.out.println(assertEquals(getFibonacciSumFast(100), 5));
        System.out.println(assertEquals(getFibonacciSumFast(160), 5));
        System.out.println(assertEquals(getFibonacciSumFast(3), 4));
        System.out.println(assertEquals(getFibonacciSumFast(63), 4));
        System.out.println(assertEquals(getFibonacciSumFast(4), 7));
        System.out.println(assertEquals(getFibonacciSumFast(64), 7));
        System.out.println(assertEquals(getFibonacciSumFast(5), 2));
        System.out.println(assertEquals(getFibonacciSumFast(65), 2));
        System.out.println(assertEquals(getFibonacciSumFast(13), 9));
        System.out.println(assertEquals(getFibonacciSumFast(73), 9));



       //  stress test
//        while (true) {
//            Random rd = new Random();
//            int n = rd.nextInt(91);
//
//            long resp1 = getFibonacciSumNaive(n);
//            long resp2 = getFibonacciSumFast(n);
//
//            if (resp1 == resp2) {
//                System.out.println("OK " + resp1);
//            } else {
//                System.out.println("Wrong answer: " + resp1 + " " + resp2);
//                System.out.println("n = " + n);
//                break;
//            }
//
//        }

    }


    private static boolean assertEquals(long fibonacciHugeFast, long expectedResult) {
        return fibonacciHugeFast == expectedResult;
    }


}
