package recursion;

public class PowersOfANumber {

    //n=0  então x⁰ =1
    //n > 0 && EVEN então y=x^n/2 e x^n =y.y
    //n > 0 && ODD então x^n-1 e x^n = x^n-1*x
    //n < 0 então x^-n e x^n = 1/x^-n

    private static int getPowersOfANumber(int x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / getPowersOfANumber(x, -n);
        }

        if (!isEven(n)) {
            return x * getPowersOfANumber(x, n - 1);
        }

        if (isEven(n)) {
            int result = getPowersOfANumber(x, n / 2);
            return result * result;
        }
        return 100;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(getPowersOfANumber(3, 0));
        System.out.println(getPowersOfANumber(3, 1));
        System.out.println(getPowersOfANumber(2, 2));
        System.out.println(getPowersOfANumber(2, 3));

    }
}
