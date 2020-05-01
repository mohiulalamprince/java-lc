import java.util.*;

public class ThreeSum {

    public static void main(String args[]) {
        List<List<Integer>> result = threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        result = result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];

            while (j < k) {

                int x = nums[j];
                int y = nums[k];

                if (nums[j] + nums[k] < target) {
                    j++;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                }
                else if (nums[i] + nums[j] + nums[k] == 0 && !map.containsKey(nums[i] + " " + nums[j] + " " + nums[k])) {
                    map.put(nums[i] + " " + nums[j] + " " + nums[k], true);
                    result.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[k])));
                } else {
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
}
