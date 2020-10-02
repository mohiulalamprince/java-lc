import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class MinimumCosttoConnectSticks {
    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < sticks.length; i++)
            pq.add(sticks[i]);

        int sum = 0;
        while (pq.size() > 1) {
            int res = pq.poll() + pq.poll();
            pq.add(res);
            sum += res;
        }
        return sum;
    }

    public static void main(String args[]) {
        System.out.println(connectSticks(new int[]{2, 4, 3}));
        System.out.println(connectSticks(new int[]{1, 8, 3, 5}));
        System.out.println(connectSticks(new int[]{5}));
    }
}
