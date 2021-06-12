package week6_dynamic_two;

import java.util.*;

public class MaximumValueOfAnArithmeticExpression {


    private static long getMaximValue(String exp) {

        char[] chars = exp.toCharArray();
        List<Long> onlyNumbers = getNumbers(chars);
        int n = onlyNumbers.size();

        Long[][] M = new Long[n + 1][n + 1];
        Long[][] m = new Long[n + 1][n + 1];

        //diagonal principal
        for (int i = 1; i <= n; i++) {
            m[i][i] = onlyNumbers.get(i - 1);
            M[i][i] = onlyNumbers.get(i - 1);
        }

        for (int s = 1; s < n; s++) {
            List<Character> signals = getSignal(chars);
            for (int i = 1; i <= n - s; i++) {
                int j = i + s;

                m[i][j] = minAndMax(i, j, M, m, signals)[0];
                M[i][j] = minAndMax(i, j, M, m, signals)[1];

                signals.remove(0);
            }
        }

        return M[1][n];
    }


    private static Long[] minAndMax(int i, int j, Long[][] M, Long[][] m, List<Character> signals) {
        Long[] minAndMax = new Long[2];
        long min = +1000000000000000000L;
        long max = -1000000000000000000L;
        int pivo = 0;

        for (int k = i; k <= (j - 1); k++) {
            char opk = signals.get(pivo);

            long a = eval(M[i][k], M[k + 1][j], opk);
            long b = eval(M[i][k], m[k + 1][j], opk);
            long c = eval(m[i][k], M[k + 1][j], opk);
            long d = eval(m[i][k], m[k + 1][j], opk);

            min = Collections.min(getList(min, a, b, c, d));
            max = Collections.max(getList(max, a, b, c, d));
            pivo++;
        }
        minAndMax[0] = min;
        minAndMax[1] = max;

        return minAndMax;
    }


    private static List<Long> getList(long min, Long a, Long b, Long c, Long d) {
        List<Long> list = new ArrayList<>();
        list.add(min);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        return list;
    }

    private static List<Long> getNumbers(char[] exp) {
        List<Long> onlyNumbers = new ArrayList<>();
        for (char c : exp) {
            if (!isOp(c)) {
                onlyNumbers.add(Long.parseLong(String.valueOf(c)));
            }
        }
        return onlyNumbers;
    }

    private static List<Character> getSignal(char[] chars) {
        List<Character> onlyChars = new ArrayList<>();
        for (char c : chars) {
            if (isOp(c)) {
                onlyChars.add(c);
            }
        }
        return onlyChars;
    }


    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    private static boolean isOp(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    public static void main(String[] args) {

        System.out.println(check(getMaximValue("5-8+7*4-8+9"), 200L));
        System.out.println(check(getMaximValue("1+5"), 6L));
        System.out.println(check(getMaximValue("0"), 0L));
        System.out.println(check(getMaximValue("0+0"), 0L));
        System.out.println(check(getMaximValue("9"), 9L));
        System.out.println(check(getMaximValue("9*9"), 81L));
        System.out.println(check(getMaximValue("1+5*6-3"), 33L));
        System.out.println(check(getMaximValue("9*5*6-3"), 267L));
        System.out.println(check(getMaximValue("1+1+1+1+1+1+1+1+1+1+1+1+1+1"), 14L));
        System.out.println(check(getMaximValue("9*9*9*9*9*9*9*9*9*9*9*9*9*9"), 22876792454961L));
        System.out.println(check(getMaximValue("9*9*9*9*9*9*9*9*9*9*9*9*9*9*9"), 205891132094649L));
        System.out.println(check(getMaximValue("6*3-2-5+5+0+0+8-6*8+0-4-2+3+2"), 1650L));
        System.out.println(check(getMaximValue("6*3-2-5+5+0+0+8-6*8+0-4-2+3+2"), 1650L));
        System.out.println(check(getMaximValue("1+0+3*5+7-3*6*4-0-7+8-4*4*1*6"), 149040L));
        System.out.println(check(getMaximValue("0*8*3+3-7*2*1+6*3*8*0-8+1-2*7"), 181125L));


    }

    private static boolean check(Long myAnswuer, Long answer) {
        return myAnswuer.equals(answer);
    }


}
