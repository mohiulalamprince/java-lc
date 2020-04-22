public class LowestCommonAncestorOfABinaryTree {
    static int answer = 0;
    public static void main(String args[]) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        calculate(root, p, q);
        return new TreeNode(answer);
    }

    boolean calculate(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int left = calculate(root.left, p, q) ? 1 : 0;
        int right = calculate(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;

        if (mid + right + left >= 2) {
            answer = root.val;
        }

        return (left + mid + right > 0);
    }
}
