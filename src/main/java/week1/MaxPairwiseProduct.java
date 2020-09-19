package week1;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {

    static long getMaxPairwiseProductFast(long[] numbers) {

        int n = numbers.length;
        long firstMax = 0;
        long secondMax = 0;
        int firstMaxIndex = 0;

        for (int i = 0; i < n; ++i) {
            if (numbers[i] > firstMax) {
                firstMax = numbers[i];
                firstMaxIndex = i;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (numbers[i] > secondMax && i != firstMaxIndex) {
                secondMax = numbers[i];
            }
        }
        return firstMax * secondMax;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}