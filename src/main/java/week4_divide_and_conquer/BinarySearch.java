package week4_divide_and_conquer;

public class BinarySearch {


    static int binarySearch(int[] a, int x, int left, int right) {

        if ((right - left) == 0) {
            return -1;
        }

        int mid = left + ((right - left) / 2);

        if (a[mid] == x) {
            return mid;
        }

        if (a[mid] < x) {
            return binarySearch(a, x, mid + 1, right);
        } else return binarySearch(a, x, left, mid);

    }


    public static void main(String[] args) {

        int[] a = {1, 5, 8, 12, 13};
        int[] b = {1, 5, 8, 11, 12, 13, 16, 18, 21, 24, 32, 34, 50, 65, 90};
        int[] c = {90};

        System.out.println(binarySearch(a, 8, 0, a.length));//2
        System.out.println(binarySearch(a, 1, 0, a.length));//0
        System.out.println(binarySearch(a, 23, 0, a.length));//-1
        System.out.println(binarySearch(a, 1, 0, a.length));//0
        System.out.println(binarySearch(a, 11, 0, a.length));//-1


        System.out.println(binarySearch(b, 11, 0, b.length - 1)); //3
        System.out.println(binarySearch(b, 32, 0, b.length)); //10
        System.out.println(binarySearch(b, 1, 0, b.length)); //0
        System.out.println(binarySearch(b, 2, 0, b.length)); //-1
        System.out.println(binarySearch(b, 65, 0, b.length)); //13

        System.out.println(binarySearch(c, 4, 0, c.length)); //-1
        System.out.println(binarySearch(c, 90, 0, c.length));//0


    }


}
