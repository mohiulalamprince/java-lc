import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    public static void main(String args[]) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode head = null;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(x -> x.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                queue.add(lists[i]);
        }

        ListNode current = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();

            if (head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = current.next;
            }

            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return head;
    }
}
