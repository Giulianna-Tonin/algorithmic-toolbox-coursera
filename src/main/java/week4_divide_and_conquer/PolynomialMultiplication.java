package week4_divide_and_conquer;

public class PolynomialMultiplication {

    //O(n²)
    public static int[] getMult(int[] A, int[] B, int n) {
        int[] product = new int[(2 * n) - 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                product[i + j] += A[i] * B[j];
            }
        }
        return product;
    }




    public static void main(String[] args) {

        int n = 3;
        int[] pol1 = {3, 2, 5};
        int[] pol2 = {5, 1, 2};

        int[] mult = getMult(pol1, pol2, n);

        for (int value : mult) {
            System.out.println(value);
        }

    }


}
