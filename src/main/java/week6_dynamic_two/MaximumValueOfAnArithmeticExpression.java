package week6_dynamic_two;

import java.util.*;

public class MaximumValueOfAnArithmeticExpression {

//    Integer itemWeight = (Integer) itemsWeightsAndValues.keySet().toArray()[i];
//    Integer itemValue = itemsWeightsAndValues.get(itemWeight);

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


        int pivo = 1;


        for(int s = 1; s < onlyNumbers.size() - 1; s++){
            int pivoInt = pivo;
            for(int i = 1; i <= onlyNumbers.size() - s; i++) {
                int j = i + s;

                char opk = chars[pivoInt];

                long[] minAndMax = MinAndMax(i, j, M, m, opk);
                m[i][j] = minAndMax[0];
                M[i][j] = minAndMax[1];

                pivoInt+=2;

            }
            pivo+=2;
        }


        return M[1][onlyNumbers.size()];
    }



    private static long[] MinAndMax(int i, int j, long[][] M, long[][] m, char opk) {
        long [] minAndMax = new long[2];
        long min = 0;
        long max = 0;

        for (int k = i; k <= (j-1); k++){


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
        }
        minAndMax[0] = min;
        minAndMax[1] = max;

        return minAndMax;
    }



    private static List<Long> getList(long min, Long a, Long b, Long c, Long d) {
        List<Long> list = new ArrayList<>();
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

//        String exp = "5-8+7*4-8+9";
        String exp = "1+5*6-3";

        getMaximValue(exp);
    }


}
