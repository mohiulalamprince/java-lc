import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeZigzagLevelOrderTraversal {
    static List<List<Integer>> result;
    public static void main(String args[]) {

    }

    List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<>();

        dfs(root, 0);

        for (int i = 1; i < result.size(); i += 2) {
            Collections.reverse(result.get(i));
        }

        return result;
    }

    public void dfs(TreeNode root, int dep) {
        if (root == null) return ;

        if (dep >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(dep).add(root.val);

        dfs(root.left, dep + 1);
        dfs(root.right, dep + 1);
    }
}
