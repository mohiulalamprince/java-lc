import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preorder(root, result, 1);
        return result;
    }

    public static void preorder(TreeNode root, ArrayList<Integer> result, int level) {
        if (root == null) return ;

        if (level > result.size())
            result.add(root.val);
        preorder(root.right, result, level + 1);
        preorder(root.left, result, level + 1);
    }
}
