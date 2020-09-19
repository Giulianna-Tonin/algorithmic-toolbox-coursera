package week2;

public class FibonacciPartialSumLastDigit {

    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    //290 //500

//    1  2  3  4  5   6   7    8    9       Index

//    1  2  4  7  12  20  33   54   88       soma

//    1  1  2  3  5   8   13   21   34       Fib




//    private static long getFibonacciPartialSumFast(long from, long to) {
//        if (to <= 1)
//            return to;
//
//        long lastDigitFrom = getFibonacciSumFast(from);
//        long partialSum = to - from;
//
//
//    }


    private static long getFibonacciSumFast(long n) {
        if (n <= 1)
            return n;
        if(n <= 60){
            return getFibonacciSumNaive(n);
        } else {
            return getFibonacciSumNaive(n%60);
        }
    }

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









}
