public class MaximumAverageSubtree {
    static class Node {
        double val;
        int count;
        Node(double val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    static double answer = 0;
    public static double maximumAverageSubtree(TreeNode root) {
        answer = 0.0;
        findAverage(root);
        return answer;
    }

    public static Node findAverage(TreeNode root) {
        if (root == null) return null;

        Node left = findAverage(root.left);
        Node right = findAverage(root.right);

        double sum = root.val;
        int count = 1;

        if (left != null) {
            sum += left.val;
            count += left.count;
        }

        if (right != null) {
            sum += right.val;
            count += right.count;
        }

        answer = Math.max(answer, sum / count);
        return new Node(sum, count);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(1);

        maximumAverageSubtree(root);
        System.out.println(answer);
    }
}
