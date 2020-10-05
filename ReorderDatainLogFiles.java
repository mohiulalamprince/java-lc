import java.util.*;
import java.util.stream.Collectors;

public class ReorderDatainLogFiles {

    static class Node {
        String identifier;
        String sequences;

        public Node(String identifier, String sequences) {
            this.identifier = identifier;
            this.sequences = sequences;
        }

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public String getSequences() {
            return sequences;
        }

        public void setSequences(String sequences) {
            this.sequences = sequences;
        }
    }
    public static void main(String args[]) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] result = reorderLogFiles(logs);
        Arrays.stream(result).forEach(x -> System.out.println(x));
    }

    public static String[] reorderLogFiles(String[] logs) {
        int counter = 0;
        String[] digitLogs = new String[logs.length];
        List<Node> charSequences = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            String sentence = logs[i];
            String[] words = sentence.split(" ");
            if (Character.isAlphabetic(words[1].charAt(0))) {
                charSequences.add(new Node(sentence.substring(0, words[0].length()),
                        sentence.substring(words[0].length() + 1)));
            }
            else if (Character.isDigit(words[1].charAt(0))) {
                digitLogs[counter++] = sentence;
            }
        }

        Collections.sort(charSequences, Comparator.comparing(Node::getSequences).thenComparing(Node::getIdentifier));

        String[] result = new String[logs.length];
        int cnt = 0;
        for (int i =0 ; i< charSequences.size(); i++) {
            result[cnt ++] = charSequences.get(i).getIdentifier() + " " + charSequences.get(i).getSequences();
        }
        for (int i = 0; i < counter; i++) {
            result[cnt++] = digitLogs[i];
        }
        return result;
    }
}
