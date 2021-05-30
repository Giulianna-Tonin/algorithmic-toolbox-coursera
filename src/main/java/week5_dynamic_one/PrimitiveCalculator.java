package week5_dynamic_one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PrimitiveCalculator {

    private static List<Integer> optimal_sequenceGreedy(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

//    66/3 = 22
//    66/2 = 33

    // errado   1, 2, 4, 5, 10, 11, 22, 66
    // certo       1, 3, 9, 10, 11, 22, 66


    //1 2 4 5
    //1 3 4 5


    //x2 +1 = x3

    private static List<Integer> optimal_sequence(int n) {

        List<Integer> sequence = new ArrayList<Integer>();

        int index = 1;
        sequence.add(0, index);


        while (index < n) {
            int x3 = index * 3;
            int x2 = index * 2;
            int plus1 = index + 1;




            if (x3 % index == 0 && x3 < n) {
                index *= 3;
            } else if (x2 % index == 0 && x2 < n) {
                index *= 2;
            } else {
                index += 1;
            }

            sequence.add(index);


        }
//        Collections.reverse(sequence);
        return sequence;
    }

    private static boolean isDivPer2(int n) {
        return n % 2 == 0;
    }

    private static boolean isDivPer3(int n) {
        return n % 3 == 0;
    }

    private static List<Integer> dp_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int [] a = new int[n+1];
        for(int i =1; i< a.length; i++){
            a[i] = a[i-1]+1;
            if (i%2 == 0)
                a[i] = Math.min(1+a[i/2], a[i]);
            if (i%3 == 0)
                a[i] = Math.min(1+a[i/3], a[i]);

        }
        int i = n;
        while (i>1) {
            sequence.add(i);
            if (a[i-1] == a[i]-1)
                i = i-1;
            else if (i%2 == 0 && (a[i/2] == a[i]-1))
                i = i/2;
            else if (i%3 == 0 && (a[i/3] == a[i]-1))
                i = i/3;
        }
        sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }


    public static void main(String[] args) {

//        System.out.println(optimal_sequence(10));
//
//        List<Integer> integers = optimal_sequence(96234);
//        System.out.println(integers);
////        List<Integer> integers = optimal_sequence(100);
////        List<Integer> integers2 = optimal_sequenceGreedy(100);
////        List<Integer> integers = optimal_sequence(1);
//
////        System.out.println(integers);
////        System.out.println(integers.size() - 1);
////
////        System.out.println(integers2);
////        System.out.println(integers2.size() - 1);

        final Random random = new Random();


        while (true) {

            int n = random.nextInt(1000000);

            List<Integer> greedy = optimal_sequenceGreedy(n);
            List<Integer> optimal = dp_sequence(n);
            int greedySize = greedy.size() - 1;
            int optimalSize = optimal.size() - 1;

            if (optimalSize <= greedySize) {
                System.out.println("OK");

            } else {
                System.out.println("Deu ruim");
                System.out.println("greedy: " + greedySize);
                System.out.println(greedy);

                System.out.println("optimal: " + optimalSize);
                System.out.println(optimal);

                break;
            }
        }


    }


}
