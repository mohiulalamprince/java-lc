import java.util.Stack;

class BSTIterator {

    Stack<TreeNode> stack = new Stack();
    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode result = stack.pop();
        takeNextRightNode(result.right);
        return result.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    public void takeNextRightNode(TreeNode root) {
        if (root == null) return ;

        stack.push(root);
        takeNextRightNode(root.left);
    }
}


public class BinarySearchTreeIterator {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator obj = new BSTIterator(root);

        while (obj.hasNext()) {
            System.out.println(obj.next());
        }
    }
}
