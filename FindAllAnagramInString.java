import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramInString {
    public static void main(String args[]) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int np = p.length();
        int ns = s.length();
        int[] scount = new int[26];
        int[] pcount = new int[26];
        ArrayList<Integer> result = new ArrayList<>();
        for (char c : p.toCharArray()) pcount[(int)c - 'a']++;

        for (int i = 0; i < ns; i++) {
            scount[(int)s.charAt(i) - 'a']++;

            if (i >= np) {
                scount[(int)s.charAt(i - np) - 'a']--;
            }

            if (Arrays.equals(pcount, scount)) {
                result.add(i - np + 1);
            }
        }
        return result;
    }
}
