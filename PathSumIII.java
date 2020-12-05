import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    static int counter = 0;
    public  void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);

        int result = pathSum(root, 8);
        System.out.println(result);
    }

    Map<Integer, Integer> map = new HashMap<>();
    public  int pathSum(TreeNode root, int sum) {
        int result = 0;
        counter = 0;

        //map.put(0, 1);
        dfs(root, 0, sum);

        return counter;
    }

    public  void dfs(TreeNode root, int sum, int target) {
        if (root == null) return ;

        int curSum = sum + root.val;

        if (curSum == target) counter++;


        counter += map.getOrDefault(curSum - target, 0);

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        dfs(root.left, curSum, target);
        dfs(root.right, curSum, target);

        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
    }
}
