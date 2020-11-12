public class SubtreeOfAnotherTree {
    public boolean isNodeEqual(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return (a.val == b.val) && isNodeEqual(a.left, b.left) && isNodeEqual(a.right, b.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && (isNodeEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    public static void main(String args[]) {

    }
}
