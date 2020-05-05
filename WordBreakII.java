import java.util.*;

public class WordBreakII {
    public static void main(String args[]) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        List<String> res = wordBreak(s, wordDict);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length() + 1];
        Map<Integer, ArrayList<String>> map = new HashMap<>();

        map.put(0, new ArrayList<>());
        map.get(0).add("");
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (dp[i] && i + len < s.length() + 1 && s.substring(i, i + len).equals(word)) {
                    dp[i + len] = true;

                    for (String str : map.get(i)) {
                        ArrayList<String> previousList =  map.getOrDefault(i + len, new ArrayList<>());
                        previousList.add(str.equals("") ? word : str + " " + word);
                        map.put(i + len, previousList);
                    }
                }
            }
        }

        return map.get(s.length()) == null ? new ArrayList<>() : map.get(s.length());
    }
}
