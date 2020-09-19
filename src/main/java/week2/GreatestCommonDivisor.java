package week2;

public class GreatestCommonDivisor {

//    Algoritmo de Euclides
//    MDC(a,b)=MDC(b,r);
//    onde r é o resto da divisão de a por b

    //GCD(1344, 217)
    //GCD(217, 42)
    //GCD(42,7)
    //GCD(7,0)
    //=7

    private static int gcdFast(int a, int b) {

        int r = a % b;

        if (r == 0) {
            return b;
        }

        return gcdFast(b, r);
    }

    private static int gcdNaive(int a, int b) {
        int current_gcd = 1;
        for (int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    public static void main(String[] args) {
        System.out.println(gcdFast(1344, 217));
        System.out.println(gcdFast(18, 35));
        System.out.println(gcdFast(28851538, 1183019));
    }
}
