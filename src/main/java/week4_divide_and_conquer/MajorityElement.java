package week4_divide_and_conquer;

public class MajorityElement {

    private static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

//
    public static int getMajorityElement(int[] nums) {
        int max = majorityElementRec(nums, 0, nums.length - 1);
        int maxR = countInRange(nums, max, 0, nums.length -1);
        int midArr = nums.length/2;

        if(maxR > midArr){
            return 1;
        } else return 0;

    }

    private static int majorityElementRec(int[] nums, int lo, int hi) {

        if (lo == hi) {
            return nums[lo];
        }

        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

//    private static int getMajorityElement(int[] nums, int lo, int hi) {
//
//        if (lo == hi) {
//            return nums[lo];
//        }
//
//        int mid = (hi - lo) / 2 + lo;
//        int left = getMajorityElement(nums, lo, mid);
//        int right = getMajorityElement(nums, mid + 1, hi);
//
//        if (left == right) {
//            return left;
//        }
//
//        int leftCount = countInRange(nums, left, lo, hi);
//        int rightCount = countInRange(nums, right, lo, hi);
//
//        return leftCount > rightCount ? left : right;
//
//    }

    public static void main(String[] args) {

        int[] a = {2, 3, 9, 2, 2};
        int[] b = {1, 2, 3, 4};
        int[] c = {1, 2, 3, 1};


        System.out.println(getMajorityElement(a)); //1
        System.out.println(getMajorityElement(b)); //0
        System.out.println(getMajorityElement(c)); //0


    }


}
