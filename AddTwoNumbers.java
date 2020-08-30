
class AddTwoNumbers {

        static ListNode head = null;

        public static void main(String args[]) {
            ListNode l1 = new ListNode(2);
            l1.next = new ListNode(4);
            l1.next.next =new ListNode(3);
            ListNode l2 = new ListNode(5);
            l2.next = new ListNode(6);
            l2.next.next = new ListNode(4);

            ListNode result = addTwoNumbers(l1, l2);
            print(result);
        }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);
            head = result;

            int carry = 0;
            while (l1 != null || l2 != null) {
                int p = (l1 != null) ? l1.val : 0;
                int q = (l2 != null) ? l2.val : 0;
                int sum = carry + p + q;
                carry = sum / 10;
                ListNode newNode = new ListNode(sum % 10);

                result.next = newNode;
                result = result.next;

                l1 = (l1 != null) ? l1.next : l1;
                l2 = (l2 != null) ? l2.next : l2;
            }

            if (carry == 1)
                result.next = new ListNode(carry);
            return head.next;
        }

        public static void print(ListNode root) {
        
            while (root != null) {
                System.out.println(root.val);
                root = root.next;
            }
        }
}
