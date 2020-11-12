import com.sun.source.tree.Tree;

import java.util.*;

public class AllNodesDistanceKinBinaryTree {

    static Map<TreeNode, TreeNode> parent;
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap<>();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList<>();
                    for (TreeNode q : queue)
                        ans.add(q.val);
                    return ans;
                }
                queue.add(null);
                dist++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.add(node.left);
                }

                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.add(node.right);
                }

                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.add(par);
                }
            }
        }
        return new ArrayList<>();
    }

    public static void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode target = root.left;
        List<Integer> ans = distanceK(root, target, 2);
        ans.stream().forEach(System.out::println);
    }
}
