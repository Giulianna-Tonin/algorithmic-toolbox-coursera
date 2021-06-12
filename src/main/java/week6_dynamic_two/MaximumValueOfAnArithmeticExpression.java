package week6_dynamic_two;

import java.util.*;

public class MaximumValueOfAnArithmeticExpression {


    private static long getMaximValue(String exp) {

        char[] chars = exp.toCharArray();
        List<Long> onlyNumbers = getNumbers(chars);

        long[][] M = new long[onlyNumbers.size()+1][onlyNumbers.size()+1];
        long[][] m = new long[onlyNumbers.size()+1][onlyNumbers.size()+1];

        //prencher as diagonais
        for(int i = 1; i <= onlyNumbers.size(); i++ ){

                m[i][i] = onlyNumbers.get(i-1);
                M[i][i] = onlyNumbers.get(i-1);
        }




        for(int s = 1; s < onlyNumbers.size(); s++){
            List<Character> signals = getSignal(chars);
            for(int i = 1; i <= onlyNumbers.size() - s; i++) {
                int j = i + s;

                long[] minAndMax = MinAndMax(i, j, M, m, signals);
                m[i][j] = minAndMax[0];
                M[i][j] = minAndMax[1];

                signals.remove(0);

            }
        }


        return M[1][onlyNumbers.size()];
    }



    private static long[] MinAndMax(int i, int j, long[][] M, long[][] m, List<Character> signals) {
        long [] minAndMax = new long[2];
        long min = +1000000000000000000L;
        long max = -1000000000000000000L;
        int pivo = 0;

        for (int k = i; k <= (j-1); k++){
            char opk = signals.get(pivo);


            Long Mik = M[i][k];
            Long MK1j = M[k+1][j];

            Long mik = m[i][k];
            Long mk1j = m[k+1][j];


            long a = eval(Mik, MK1j, opk);
            long b = eval(Mik, mk1j, opk);
            long c = eval(mik, MK1j, opk);
            long d = eval(mik, mk1j, opk);
            List<Long> valsMin = getList(min, a, b, c, d);
            List<Long> valsMax = getList(max, a, b, c, d);

            min = Collections.min(valsMin);
            max = Collections.max(valsMax);
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

    private static List<Object> getAll(char[] chars) {
        List<Object> all = new ArrayList<>();
        all.add(0,0);
        for (char c : chars) {
            if (isOp(c)) {
                all.add(c);
            } else {
                all.add(Long.parseLong(String.valueOf(c)));
            }
        }
        return all;
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

    private static boolean isOp (char c) {
        return c == '+' || c == '-' || c == '*';
    }

    public static void main(String[] args) {

        String exp = "5-8+7*4-8+9";
//        String exp = "1+5*6-3";

        System.out.println(getMaximValue(exp));
    }


}
