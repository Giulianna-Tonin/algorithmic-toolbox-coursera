package week5_dynamic_one;

import java.util.*;


public class EditDistance {



    public static int editDistance(String s, String t) {
        List<Character> listS = new ArrayList<>();
        List<Character> listT = new ArrayList<>();
        transform(s, t, listS, listT);

        int[][] D = new int[listT.size()][listS.size()];
        fillFirst(D, listT.size(), listS.size());


        for (int j = 1; j < listS.size(); j++) {
            for (int i = 1; i < listT.size(); i++) {

                char charS = listS.get(j);
                char charT = listT.get(i);

                Integer insert = D[i][j - 1] + 1;
                Integer delete = D[i - 1][j] + 1;
                Integer mismatch = D[i - 1][j - 1] + 1;
                Integer match = D[i - 1][j - 1];

                if (charS == charT) {
                    D[i][j] = Collections.min(getList(insert, delete, match));
                } else {
                    D[i][j] = Collections.min(getList(insert, delete, mismatch));
                }
            }
        }

        return D[listT.size()-1][listS.size()-1];
    }

    private static void transform(String s, String t, List<Character> listS, List<Character> listT) {
        char[] sS = s.toCharArray();
        char[] tS = t.toCharArray();
        listS.add(0, 'x');
        listT.add(0, 'x');

        for (char c : sS) {
            listS.add(c);
        }

        for (char c : tS) {
            listT.add(c);
        }
    }

    private static void fillFirst(int[][] d, int t, int s) {

        for (int i = 0; i < t; i++) {
            d[i][0] = i;
        }

        for (int j = 0; j < s; j++) {
            d[0][j] = j;
        }

    }


    public static void main(String args[]) {

//        String s = "ab";
//        String t = "ab";

//        String s = "short";
//        String t = "ports";
//
//        String s = "distance";
//        String t = "editing";
//
//        String s = "axybc";
//        String t = "abc";
//
        String s = "bread";
        String t = "really";

        System.out.println(editDistance(s, t));

    }


    private static List<Integer> getList(Integer insert, Integer delete, Integer match) {
        List<Integer> list = new ArrayList<>();
        list.add(insert);
        list.add(delete);
        list.add(match);
        return list;
    }



}
