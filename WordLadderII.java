import javafx.util.Pair;

import java.security.spec.MGF1ParameterSpec;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        wordList.add(beginWord);
        List<String> newWordList = wordList.stream().map(x -> {
                        return Stream.of(x.split(""))
                            .sorted()
                            .collect(Collectors.joining());
                        }).collect(Collectors.toList());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                if (i != j && newWordList.get(i).length() == newWordList.get(j).length()) {
                    int counter = 0;
                    for (int k = 0; k < newWordList.get(i).length(); k++) {
                        if (newWordList.get(i).charAt(k) != newWordList.get(j).charAt(k)) {
                            counter++;
                        }
                    }
                    if (counter == 1) {
                        List<Integer> list = graph.get(i);
                        list.add(j);
                        graph.set(i, list);

                        List<Integer> list2 = graph.get(j);
                        list2.add(i);
                        graph.set(j, list2);
                    }
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

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
