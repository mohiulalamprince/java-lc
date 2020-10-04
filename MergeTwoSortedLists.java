public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;

        while (l1 != null && l2 != null) {
            int x = l1.val;
            int y = l2.val;

            if (x < y) {
                result.next = new ListNode(x);
                l1 = l1.next;
                result = result.next;
            } else if (y < x) {
                result.next = new ListNode(y);
                l2 = l2.next;
                result = result.next;
            } else {
                result.next = new ListNode(x);
                result.next.next = new ListNode(y);
                l1 = l1.next;
                l2 = l2.next;
                result = result.next.next;
            }
        }
        if (l2 != null) {
            while (l2 != null) {
                result.next = new ListNode(l2.val);
                result = result.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            while (l1 != null) {
                result.next = new ListNode(l1.val);
                result = result.next;
                l1 = l1.next;
            }
        }
        return head.next;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);

        ListNode head = mergeTwoLists(l1, l2);
    }
}
