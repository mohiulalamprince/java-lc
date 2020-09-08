import java.util.*;
import java.util.stream.Collectors;

public class GroupAanagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] key = strs[i].toCharArray();

            Arrays.sort(key);
            String sortKey = new String(key);

            List<String> list = map.getOrDefault(sortKey, new ArrayList<>());
            list.add(strs[i]);
            map.put(sortKey, list);
        }
        for (Map.Entry<String, List<String>> record : map.entrySet()) {
            List<String> groupList = record.getValue();
            result.add(groupList);
        }
        return result;
    }

    public static void main(String args[]) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(str);
    }
}
