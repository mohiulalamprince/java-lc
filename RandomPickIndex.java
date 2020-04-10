import java.util.*;

public class RandomPickIndex {
    private Map<Integer, List<Integer>> map;

    public RandomPickIndex(int[] nums) {
        this.map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) map.put(num, new ArrayList<>());
            map.get(num).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indexes = map.get(target);
        int i = (int) (Math.random() * indexes.size());
        return indexes.get(i);
    }
}
