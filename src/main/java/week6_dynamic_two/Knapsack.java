package week6_dynamic_two;

import java.util.*;

public class Knapsack {


    //com repetição (LISTA)
    static int optimalWeightWhitRepetition(int knapsackMaxWeight, Map<Integer, Integer> itemsWeightsAndValues) {

        int[] maxValueOfMoney = new int[knapsackMaxWeight + 1];
        maxValueOfMoney[0] = 0;

        for (int knapsackWeight = 1; knapsackWeight <= knapsackMaxWeight; knapsackWeight++) {
            maxValueOfMoney[knapsackWeight] = 0;

            for (int i = 0; i < itemsWeightsAndValues.size(); i++) {

                Integer itemWeight = (Integer) itemsWeightsAndValues.keySet().toArray()[i];
                Integer itemValue = itemsWeightsAndValues.get(itemWeight);

                if (itemWeight <= knapsackWeight) {

                    int subProblemInterval = knapsackWeight - itemWeight;
                    int currMaxValueOfMoney = maxValueOfMoney[subProblemInterval] + itemValue;

                    if (currMaxValueOfMoney > maxValueOfMoney[knapsackWeight]) {
                        maxValueOfMoney[knapsackWeight] = currMaxValueOfMoney;
                    }

                }
            }
        }

        return maxValueOfMoney[knapsackMaxWeight];
    }


    //sem repetição (MATRIZ)
    static int optimalWeightWithoutRepetition(int W, Map<Integer, Integer> n) {

        n.put(0,0);
        W += 1;
        int[][] value = new int[W][n.size()];

        for (int i = 1; i < n.size(); i++) {

            Integer itemWeight = (Integer) n.keySet().toArray()[i];
            Integer itemValue = n.get(itemWeight);

            for (int  w = 1; w < W; w++) {

                value[w][i] = value[w][i-1];

                if (itemWeight <= w) {
                    int subProblemInterval = w - itemWeight;

                    int currentVal = value[subProblemInterval][i-1] + itemValue;
                    if(value[w][i] < currentVal) {
                        value[w][i] = currentVal;
                    }

                }
            }
        }

        return value[W-1][n.size()-1];
    }

    //greedy
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0;
        for (int i = 0; i < w.length; i++) {
            if (result + w[i] <= W) {
                result += w[i];
            }
        }
        return result;
    }

    static int optimalWeightWithoutRepetitionWhitGold(int W, int[] w) {

        List<Integer> nList = transform(w);
        W += 1;
        int[][] value = new int[W][nList.size()];

        for (int i = 1; i < nList.size(); i++) {

            //gold, então peso igual valor
            Integer itemWeight = nList.get(i);
            Integer itemValue = nList.get(i);

            for (int  j = 1; j < W; j++) {

                value[j][i] = value[j][i-1];

                if (itemWeight <= j) {
                    int subProblemInterval = j - itemWeight;

                    int currentVal = value[subProblemInterval][i-1] + itemValue;
                    if(value[j][i] < currentVal) {
                        value[j][i] = currentVal;
                    }

                }
            }
        }

        return value[W-1][nList.size()-1];
    }

    private static List<Integer> transform(int[] n) {

        List<Integer> nList = new ArrayList<>();


        for(int i = 0; i < n.length; i++){
            nList.add(i, n[i]);
        }

        nList.add(0, 0);

        return nList;
    }


    public static void main(String[] args) {

//        int knapsackMaxWeight = 10;
//        Map<Integer, Integer> itemsWeightsAndValues = new HashMap<>();
//        itemsWeightsAndValues.put(2, 9);
//        itemsWeightsAndValues.put(4, 16);
//        itemsWeightsAndValues.put(3, 14);
//
//        itemsWeightsAndValues.put(6, 30);


        int knapsackMaxWeight = 10;
        Map<Integer, Integer> itemsWeightsAndValues = new HashMap<>();
        itemsWeightsAndValues.put(1, 1);
        itemsWeightsAndValues.put(4, 4);
        itemsWeightsAndValues.put(8, 8);

        int W = 10;
        int[] n = {1, 4, 8};


//        System.out.println(optimalWeightWhitRepetition(knapsackMaxWeight, itemsWeightsAndValues));
//        System.out.println(optimalWeightWithoutRepetition(knapsackMaxWeight, itemsWeightsAndValues));
        System.out.println(optimalWeightWithoutRepetitionWhitGold(W, n));


    }


}
