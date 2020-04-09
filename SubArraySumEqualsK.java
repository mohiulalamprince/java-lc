import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String args[]) {
    }

    public static int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int counter = 0;
        int current_sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            current_sum += nums[i];
            counter += map.getOrDefault(current_sum - k, 0);
            map.put(current_sum, map.getOrDefault(current_sum, 0) + 1);
        }
        return counter;
    }
}
