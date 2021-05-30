package week3_greedy;

public class DotProduct {

    private static long maxDotProduct(long[] a, long[] b) {

        sort(a);
        sort(b);

        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    private static void sort(long[] arr) {
        for(int i = 0; i < arr.length; i++){
            long curr = arr[i];
            int nextLowPos = findNextLowPos(arr, i, curr);
            long nextLow = arr[nextLowPos];

            if(nextLow < curr) {
                arr[i] = nextLow;
                arr[nextLowPos] = curr;
            }
        }
    }

    private static int findNextLowPos(long[] arr, int currePos, long curr) {
        long nextLow = curr;
        int nextLowPos = currePos;

        for(int j = currePos+1; j < arr.length; j++){
            long currJ = arr[j];
            if(currJ < nextLow){
                nextLow = currJ;
                nextLowPos = j;
            }
        }
        return nextLowPos;
    }

    public static void main(String[] args) {



        long[] a = {1, 3, -5};
        long[] b = {-2, 4, 1};

        long[] a1 = {23};
        long[] b2 = {39};

        System.out.println(maxDotProduct(a, b));
        System.out.println(maxDotProduct(a1, b2));





    }


}
