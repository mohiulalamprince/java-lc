public class MissingElementInSortedArray {
    public static void main(String args[]) {
        System.out.println(missingElement(new int[]{4, 7, 9, 10}, 3));
    }

    public static int missingElement(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int missing = nums[mid] - nums[0] - mid;
            if (missing >= k) right = mid - 1;
            else left = mid + 1;
        }
        return result = nums[0] + right + k;
    }
}
