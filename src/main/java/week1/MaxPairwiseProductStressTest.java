package week1;

import java.util.Random;

public class MaxPairwiseProductStressTest {

    static long getMaxPairwiseProduct(long[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                        numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

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

        while (true) {

            Random rd = new Random();

            long[] arr = new long[1000];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rd.nextInt(200000);
            }

            long resp1 = getMaxPairwiseProduct(arr);
            long resp2 = getMaxPairwiseProductFast(arr);

            if (resp1 == resp2) {
                System.out.println("OK " + resp1);
            } else {
                System.out.println("Wrong answer - " + resp1 + " " + resp2);
                for (long value : arr) {
                    System.out.println(value);
                }
                break;
            }
        }
    }

}
