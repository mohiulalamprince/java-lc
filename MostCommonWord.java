import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MostCommonWord {
    public static void main(String args[]) {
        Consumer<String> out = System.out::println;
        String[] res = "a, a, a, a, b,b,b, c".split("[,?!.;]");

        out.accept(mostCommonWord("a, a, a, a, b,b,b, c", new String[]{"a"}));
        out.accept(mostCommonWord("Bob hit a ball;, the; hit BALL flew far after it was hit.",
                new String[] {"hit"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String result = "";
        Consumer<String> out = System.out::println;
        List<String> bannedStream = Arrays
                .stream(banned)
                .collect(Collectors.toList());

        Predicate<String> ignoreBanned = x -> bannedStream.contains(x) == false;

        Map<String, Long> wordsGroup = Arrays
                .stream(paragraph.split("[ ,.?!';]"))
                .map(x -> x.toLowerCase()
                        .replaceAll("[,.?!';]", " ").trim())
                .filter(x -> !x.isEmpty())
                .filter(ignoreBanned)
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()));

        result = wordsGroup.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .findFirst()
                .get()
                .getKey();

        return result;
    }
}
