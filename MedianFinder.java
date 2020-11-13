import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    static PriorityQueue<Integer> lo = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> hi = new PriorityQueue<>();
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public static void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());

        if (lo.size() < hi.size()) {
            lo.add(hi.poll());
        }
    }

    public static double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (double)(lo.peek() + hi.peek()) * 0.5;
    }

    public static void main(String args[]) {

    }
}
