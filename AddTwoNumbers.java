
class AddTwoNumbers {

        static ListNode head;

        public static void main(String args[]) {
            ListNode l1 = new ListNode(5);
            ListNode l2 = new ListNode(6);

            ListNode result = addTwoNumbers(l1, l2);
            print(result);
        }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = null;
            head = result;

            int carry = 0;
            while (l1 != null && l2 != null) {
                int sum = carry + l1.val + l2.val;
                carry = sum % 10;
                ListNode newNode = new ListNode(sum / 10);

                if (result == null)
                    result = newNode;
                else {
                    result.next = newNode;
                }

                l1 = l1.next;
                l2 = l2.next;
            }

            while (l1 != null) {
                result.next = new ListNode((carry + l1.val) % 10);
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
            }

            while (l2 != null) {
                result.next = new ListNode((carry + l2.val) % 10);
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
            }
            return head;            
        }

        public static void print(ListNode root) {
        
            while (root != null) {
                System.out.println(root.val);
                root = root.next;
            }
        }
}
