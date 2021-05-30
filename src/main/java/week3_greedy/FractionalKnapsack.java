package week3_greedy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class FractionalKnapsack {


    private static double getOptimalValue(double capacity, double[] values, double[] weights) {
        double value = 0;

        double[] valuesPerWeight = new double[weights.length];

        for (int i = 0; i < weights.length; i++) {
            valuesPerWeight[i] = values[i] / weights[i];
        }

        sortValuePerWeight(valuesPerWeight, weights);

        for (int i = 0; i < valuesPerWeight.length; i++) {
            if (capacity != 0) {
                if (weights[i] > capacity) {
                    value += (valuesPerWeight[i] * capacity);
                    capacity -= capacity;
                } else {
                    capacity -= weights[i];
                    value += (valuesPerWeight[i] * weights[i]);
                }
            }
        }

        BigDecimal bigDecimal = BigDecimal.valueOf(value).setScale(4, RoundingMode.UP);
        return bigDecimal.doubleValue();


    }


    private static void sortValuePerWeight(double[] valuesPerWeight, double[] weights) {

        for (int i = 0; i < valuesPerWeight.length; i++) {
            double current = valuesPerWeight[i];
            int nextMaxPos = findNextMaxIndicePos(valuesPerWeight, current, i);
            double nextMax = valuesPerWeight[nextMaxPos];

            if (current < nextMax) {
                valuesPerWeight[i] = nextMax;
                valuesPerWeight[nextMaxPos] = current;

                double temW = weights[i];
                weights[i] = weights[nextMaxPos];
                weights[nextMaxPos] = temW;

            }
        }
    }


    private static int findNextMaxIndicePos(double[] valuesPerWeight, double current, int currentPos) {
        double nextMax = current;
        int nextMaxPos = currentPos;

        for (int j = currentPos + 1; j < valuesPerWeight.length; j++) {

            if (valuesPerWeight[j] > nextMax) {
                nextMax = valuesPerWeight[j];
                nextMaxPos = j;
            }
        }
        return nextMaxPos;
    }

    public static void main(String[] args) {

        int W = 2000000;

        Random rd = new Random();

        double[] values = new double[1000];
        for (int i = 0; i < values.length; i++) {
            values[i] = rd.nextInt(2000000);
        }

        double[] weight = new double[1000];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = rd.nextInt(200000);
        }

        System.out.println(getOptimalValue(W, values, weight));

        int capacity1 = 50;
        double[] values1 = {60, 100, 120};
        double[] weight1 = {20, 50, 30};

        int capacity2 = 10;
        double[] values2 = {500};
        double[] weight2 = {30};

        System.out.println(getOptimalValue(capacity1, values1, weight1));
        System.out.println(getOptimalValue(capacity2, values2, weight2));


    }


}
