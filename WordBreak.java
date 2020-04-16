import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String args[]) {
        System.out.println(wordBreak("catsandog", new ArrayList<>(Arrays.asList("leet", "code", "cats", "dog", "sand", "and", "cat"))));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length() + 1];

        dp[0] = true;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (dp[i] && i + len <= n && s.substring(i, i + len).equals(word))
                    dp[i+word.length()] = true;
            }
        }
        return dp[s.length()];
    }
}
