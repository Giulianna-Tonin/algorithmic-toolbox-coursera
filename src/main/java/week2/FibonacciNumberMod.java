package week2;

import java.math.BigInteger;

public class FibonacciNumberMod {

    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static Long getFibonacciHugeFast(Long n, Long m) {
        if (n <= 1) {
            return n;
        }

        Long pisanoPeriod = getPisanoPeriod(m);
        Long r = n % pisanoPeriod;

        if (r.equals(n)) {
            return getFibonacciHugeForGreaterNumbers(n, m);
        } else return getFibonacciHugeForGreaterNumbers(r, m);
    }

//    A Pisano Period starts with 0 1

//    You compute the pisano period by generating the fibonnaci integers % m.
//    As you generate this seq, you test for the patter 0, 1.
//    If you find it now you know that your pisano period is the number
//    of integers you generated before the 0, 1 sequence appeared.

//       0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610
// mod2  0  1  1  0  1  0  0  1   1   0   1   1   0    1    1    0     = ciclo de 3
// mod3  0  1  1  2  0  2  2  1   0   1   1   2   0    2    2    1     = ciclo de 8
//

    private static long getPisanoPeriod(long m) {
        long previous = 0;
        long current = 1;
        long pisanoPeriod = 0;

        for (long i = 0; i < m * m; i++) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;

            if (previous == 0 && current == 1) {
                pisanoPeriod = i;
                break;
            }
        }
        return pisanoPeriod + 1;
    }

    private static Long getFibonacciHugeForGreaterNumbers(Long n, Long m) {
        if (n <= 1)
            return n;

        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;

        for (long i = 0L; i < n - 1; ++i) {
            BigInteger tmp_previous = previous;
            previous = current;
            current = tmp_previous.add(current);
        }

        BigInteger mod = current.mod(BigInteger.valueOf(m));

        return mod.longValue();
    }

    public static void main(String[] args) {

        System.out.println(assertEquals(getFibonacciHugeFast(2015L, 3L), 1));
        System.out.println(assertEquals(getFibonacciHugeFast(239L, 1000L), 161));
        System.out.println(assertEquals(getFibonacciHugeFast(2816213588L, 239L), 151));
        System.out.println(assertEquals(getFibonacciHugeFast(9999999999999L, 2L), 0));
        System.out.println(assertEquals(getFibonacciHugeFast(9999999999999L, 1000L), 626));

    }

    private static boolean assertEquals(long fibonacciHugeFast, long expectedResult) {
        return fibonacciHugeFast == expectedResult;
    }

}
