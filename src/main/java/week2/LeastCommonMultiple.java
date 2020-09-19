package week2;

public class LeastCommonMultiple {

//    LCM(a,b)= (ab)/(GCD(a,b))

    private static long lcmNaive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    private static long lcmFast(long a, long b) {
        long gcd = gcdFast(a, b);
        long prod = a * b;

        return prod/gcd;
    }

    private static long gcdFast(long a, long b) {

        long r = a % b;

        if (r == 0) {
            return b;
        }

        return gcdFast(b, r);
    }

    public static void main(String[] args) {
        System.out.println(lcmFast(6,8));
        System.out.println(lcmFast(761457,614573));
    }
}
