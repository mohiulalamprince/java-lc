import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[]{};
        if (k == 1) return nums;
        if (nums.length == 1) return nums;

        List<Integer> res = new ArrayList<>();

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.getFirst() == i - k)
                deque.removeFirst();

            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i] ) {
                deque.removeLast();
            }

            deque.addLast(i);

            //k = 3 : i = 2
            if (i + 1 >= k) {
                res.add(nums[deque.getFirst()]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String args[]) {
        //int[] res = maxSlidingWindow(new int[] {1, 3,-1, -3, 5, 3, 6, 7}, 3);
        int[] res = maxSlidingWindow(new int[] {1, 3, 1, 2, 0, 5}, 3);
        //int[] res = maxSlidingWindow(new int[] {9, 11}, 2);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
}
