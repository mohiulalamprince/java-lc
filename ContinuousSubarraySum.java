import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static void main(String args[]) {
        System.out.println(checkSubarraySum(new int[]{1, 0}, 2));
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(checkSubarraySum(new int[]{23, 0, 0}, 6));
        System.out.println(checkSubarraySum(new int[]{23, 0, 0}, -6));
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(checkSubarraySum(new int[]{5, 0, 0}, 0));
        System.out.println(checkSubarraySum(new int[]{0, 0, 5}, 0));
        System.out.println(checkSubarraySum(new int[]{0, 4, 2, 1, 0, 4, 0, 4, 1}, 7));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 && nums[i-1] == 0) return true;
        }

        if (k == 0) return false;

        int current_sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            current_sum = (current_sum + nums[i]) % k;

            if (current_sum == 0 && i > 0) return true;
            if (map.containsKey(current_sum) && map.get(current_sum) < i -1) {
                return true;
            }

            map.put(current_sum, i);
        }
        return false;
    }
}
