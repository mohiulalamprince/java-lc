import javafx.util.Pair;

import java.util.*;

public class WordLadderII {

    static class Node {
        List<String> paths;
        String word;
        Node(List<String> paths, String word) {
            this.paths = paths;
            this.word = word;
        }
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        return result;
    }

    public static void main(String args[]) {
        List<List<String>> result = findLadders("hit", "cog", new ArrayList(Arrays.asList("hot", "dot",
                "dog", "lot", "log")));
        result.forEach(x -> {
            for (int i = 0; i < x.size(); i++) {
                System.out.print(x.get(i));
            }
            System.out.println();
        });
    }
}
