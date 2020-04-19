import java.util.Arrays;

public class NextPermutation {
    public static void main(String args[]) {
        int nums[] = new int[] {1, 5, 1};
        nextPermutation(nums);
        nums = new int[]{1, 2, 3};
        nextPermutation(nums);
        int i = 0;
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        int n = nums.length;

        int i = 0;
        int j = 0;
        int prev = nums[n - 1];
        boolean found = false;
        for (i = n - 2; i >= 0; i--) {
            if (prev > nums[i]) {
                found = true;
                int target = i;
                for (j = i  + 1; j < n; j++) {
                    if (nums[target] >= nums[j]) {

                        swap(target, j - 1, nums);
                        reverse(nums, target + 1, n -1);
                        break;
                    }
                }
                if (j == n) {
                    int t = nums[target];
                    nums[target] = nums[n -1];
                    nums[n -1] = t;

                    reverse(nums, target + 1, n -1);
                }
                if (found) break;
            } else {
                prev = nums[i];
            }
        }
        if (i < 0)
            Arrays.sort(nums);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(start, end, nums);
            start ++;
            end --;
        }
    }

    public static void swap(int x, int y, int[] nums) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
