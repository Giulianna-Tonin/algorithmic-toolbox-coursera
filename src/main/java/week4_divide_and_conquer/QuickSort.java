package week4_divide_and_conquer;

import java.util.Random;

public class QuickSort {

    private static final Random random = new Random();

    private static void randomizedQuickSort(long[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        long t = a[l];
        a[l] = a[k];
        a[k] = t;

        int m = partition2(a, l, r);
        randomizedQuickSort(a, l, m - 1);
        randomizedQuickSort(a, m + 1, r);
    }

    private static void randomizedQuickSort3Partition(long[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        long t = a[l];
        a[l] = a[k];
        a[k] = t;

        int[] m = partition3(a, l, r);
        int m1 = m[0];
        int m2 = m[1];

        randomizedQuickSort3Partition(a, l, m1 - 1);
        randomizedQuickSort3Partition(a, m2 + 1, r);
    }

    private static int[] partition3(long[] a, int l, int r) {
        long x = a[l];
        int m1 = l;

        for (int i = l + 1; i <= r; i++) {
            if (a[i] < x) {
                m1++;
                swap(a, m1, i);
            }
        }

        int m2 = m1;

        for (int i = m1 + 1; i <= r; i++) {
            if (a[i] == x) {
                m2++;
                swap(a, m2, i);
            }
        }

        swap(a, l, m1);

        return new int[]{m1, m2};
    }


    private static int partition2(long[] a, int l, int r) {
        long x = a[l];
        int j = l;

        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                swap(a, j, i);
            }
        }
        swap(a, l, j);
        return j;
    }


    private static void swap(long[] a, int j, int i) {
        long temp = a[i];

        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        while (true) {

            long[] arr = new long[100000];
            for (int i = 0; i < arr.length; i++) {
                long leftLimit = 1L;
                long rightLimit = 1000000000L;
                long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
                arr[i] = generatedLong;
            }

            long[] arrCopy2Partition = new long[arr.length];
            System.arraycopy(arr, 0, arrCopy2Partition, 0, arrCopy2Partition.length);

            long[] arrCopy3Partition = new long[arr.length];
            System.arraycopy(arr, 0, arrCopy3Partition, 0, arrCopy3Partition.length);

            randomizedQuickSort(arrCopy2Partition, 0, arrCopy2Partition.length - 1);
            randomizedQuickSort3Partition(arrCopy3Partition, 0, arrCopy3Partition.length - 1);

            if (isEquals(arrCopy2Partition, arrCopy3Partition)) {
                System.out.println("ok");
            } else {
                System.out.println("Wrong answer");

                System.out.println("arr:");
                for (long l : arr) {
                    System.out.println(l);
                }
                System.out.println("arr2Partition:");
                for (long l : arrCopy2Partition) {
                    System.out.println(l);
                }

                System.out.println("arr3Partition:");
                for (long l : arrCopy3Partition) {
                    System.out.println(l);
                }
                break;
            }
        }


    }

    private static boolean isEquals(long[] arrCopy2Partition, long[] arrCopy3Partition) {

        for (int i = 0; i < arrCopy2Partition.length; i++) {
            if (arrCopy2Partition[i] != arrCopy3Partition[i]) {
                return false;
            }
        }
        return true;
    }


}

