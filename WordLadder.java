import javafx.util.Pair;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0, index = 0;
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.get(i).length(); j++) {
                String newWord = wordList.get(i).substring(0, j) + '*' + wordList.get(i).substring(j + 1);
                List<String> transform = map.getOrDefault(newWord, new ArrayList<>());
                transform.add(wordList.get(i));
                map.put(newWord, transform);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        queue.add(new Pair(beginWord, 1));
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int cost = node.getValue();
            for (int i = 0; i < beginWord.length(); i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1);
                for (String adjWord : map.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjWord.equals(endWord)) {
                        return cost + 1;
                    }
                    else {
                        if (!visited.containsKey(adjWord)) {
                            visited.put(adjWord, true);
                            queue.add(new Pair(adjWord, cost + 1));
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int result = ladderLength("hit", "cog", new ArrayList(Arrays.asList("hot", "dot",
                "dog", "lot", "log")));
        System.out.println(result);
    }
}
