import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDictionary {
    static class TreeNode {
        char character;
        Map<Character, TreeNode> child;

        public TreeNode(char character) {
            character = character;
            child = new HashMap<>();
        }

        boolean isEnd() {
            if (this.child.containsKey('*')) return true;
            return false;
        }
    }
    static TreeNode root;

    public static void main(String args[]) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");

        //obj.search("bad");
        //obj.search("dad");
        obj.search(".ad");
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TreeNode('S');
    }

    /** Adds a word into the data structure. */
    public static void addWord(String word) {

        TreeNode current = root;

        for (char c : word.toCharArray()) {
            if (current.child.containsKey(c)) {
                current = current.child.get(c);
            } else {
                current.child.put(c, new TreeNode(c));
                current = current.child.get(c);
            }
        }
        current.child.put('*', new TreeNode('*'));
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    public static boolean dfs(TreeNode root, String word, int index) {

        if (index == word.length()) {
            return root.isEnd();
        }
        char c = word.charAt(index);

        if (c != '.') {
            if (root.child.containsKey(c)) {
                return dfs(root.child.get(c), word, index + 1);
            }
        } else {
            for (Map.Entry<Character, TreeNode> item : root.child.entrySet()) {
                char ch = item.getKey();
                if (dfs(root.child.get(ch), word, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
