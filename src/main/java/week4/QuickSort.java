package week4;

public class QuickSort {


    private static void quickSort(int[] a, int l, int r) {

        if (l >= r) {
            return;
        }

        int m = partition(a, l, r);
        quickSort(a, l, m - 1);
        quickSort(a, m + 1, r);

    }

    private static int partition(int[] a, int l, int r) {
        int pivot = a[l];
        int j = l;

        for (int i = l + 1; i < r; i++) {
            int current = a[i];
            if (current <= pivot) {
                j += 1;
                swap(a, j, i);
            }
        }

        swap(a, l, j);
        return j;
    }


    private static void swap(int[] a, int j, int i) {
        int jVal = a[j];
        int iVal = a[i];

        a[j] = iVal;
        a[i] = jVal;

    }

    public static void main(String[] args) {
        int a[] = {6, 4, 8, 2, 9, 3, 9, 4, 7, 6, 1};
        int b[] = {6, 4, 8, 2, 9, 3, 7, 1, 5};

        quickSort(a, 0, a.length);

        for (int value : a) {
            System.out.println(value);
        }

        quickSort(b, 0, b.length);

        for (int value : b) {
            System.out.println(value);
        }
    }

}
