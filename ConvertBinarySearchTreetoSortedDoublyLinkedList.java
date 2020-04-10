public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    static Node head = null;

    public static void main(String args[]) {
        Node root = new Node(4, null, null);
        root.left = new Node(2, null, null);
        root.left.right = new Node(3, null, null);
        root.left.left = new Node(1, null, null);
        root.right = new Node(5, null, null);

        treeToDoublyList(root);
    }

    public static Node treeToDoublyList(Node root) {
        inorder(root);
        return head;
    }

    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        insert(root.val);
        inorder(root.right);
    }

    public static void insert(int value) {
        if (head == null) {
            Node node = new Node(value, null, null);
            head = node;
            node.right = node;
            node.left = node;
            return ;
        }

        Node tail = head.left;
        Node newNode = new Node(value, null, null);
        tail.right = newNode;
        newNode.left = tail;
        newNode.right = head;
        head.left = newNode;
    }
}
