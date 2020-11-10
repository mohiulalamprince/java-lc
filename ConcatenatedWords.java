import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords {
    static HashSet<String> set;

    public static void main(String agrs[]) {
        List<String> res = findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
        res.stream().forEach(System.out::println);
    }

    public static boolean isOk(String s) {
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);

            if (set.contains(prefix) && (set.contains(suffix) || isOk(suffix))) {
                return true;
            }
        }
        return false;
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet<>();
        set.clear();
        for (String s : words) {
            set.add(s);
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isOk(word)) {
                res.add(word);
            }
        }
        return res;
    }
}
