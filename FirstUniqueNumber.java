import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class FirstUnique {

    static Map<Integer, Boolean> map = new HashMap<>();
    static Queue<Integer> queue = new ArrayDeque<>();
    public static void main(String args[]) {

    }

    public FirstUnique(int[] nums) {
        for (int num : nums)
            this.add(num);
    }

    public static int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.peek()))
            queue.poll();

        if (!queue.isEmpty())
            return queue.peek();
        return -1;
    }

    public static void add(int value) {
        if (!map.containsKey(value)) {
            map.put(value, false);
            queue.add(value);
        }
        else {
            map.put(value, true);
        }
    }
}
