public class PathSumIII {
    static int counter = 0;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        int result = pathSum(root, 0);
        System.out.println(result);
    }

    public static int pathSum(TreeNode root, int sum) {
        int result = 0;
        counter = 0;

        dfs(root, 0, sum);

        return result;
    }

    public static int dfs(TreeNode root, int sum, int target) {
        if (root == null) return 0;

        if (target == sum) counter++;

        int leftSum = 0;
        int rightSum = 0;
        if (root.left != null)
            leftSum = dfs(root.left, sum, target);
        if (root.right != null)
            rightSum = dfs(root.right, sum, target);

        if (sum + root.val + leftSum == target) counter++;
        if (sum + leftSum == target) counter++;
        if (sum + rightSum == target) counter++;
        if (leftSum == target) counter++;
        if (rightSum == target) counter++;
        if (root.val + leftSum == target) counter++;
        if (root.val + rightSum == target) counter++;

        return root.val + sum;
    }
}
