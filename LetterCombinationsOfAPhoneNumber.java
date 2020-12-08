import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    Map<String, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        result.clear();

        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        if (digits.length() != 0) {
            dfs("", digits);
        }
        return result;
    }

    public void dfs(String str, String digits) {

        if (digits.length() == 0) {
            result.add(str);
        } else {
            String digit = "" + digits.charAt(0);
            String mapLetter = map.get(digit);

            for (int i = 0; i < mapLetter.length(); i++) {
                String letter = "" + mapLetter.charAt(i);

                dfs(str + letter, digits.substring(1));
            }
        }
    }
}
