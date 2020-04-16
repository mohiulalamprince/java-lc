import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {
    public static void main(String args[]) {
        List<List<String>> accounts = new ArrayList<>();
        //accounts.add(new ArrayList<>(Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co")));
        //accounts.add(new ArrayList<>(Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co")));
        //accounts.add(new ArrayList<>(Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("David","David0@m.co","David1@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("David","David3@m.co","David4@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("David","David4@m.co","David5@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("David","David2@m.co","David3@m.co")));
        accounts.add(new ArrayList<>(Arrays.asList("David","David1@m.co","David2@m.co")));
        List<List<String>> result = accountsMerge(accounts);
        result= result;
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        Map<String, LinkedList<Integer>> mapEmailToIds = new HashMap<>();
        Map<Integer, LinkedList<String>> mapIdToEmails = new HashMap<>();
        Map<Integer, LinkedList<Integer>> matrix = new HashMap<>(accounts.size());

        Vector<Vector<Integer>> vec = new Vector<>(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                if (mapEmailToIds.containsKey(account.get(j))) {
                    mapEmailToIds.get(account.get(j)).add(i);
                }
                else {
                    mapEmailToIds.put(account.get(j), new LinkedList<>());
                    mapEmailToIds.get(account.get(j)).add(i);
                }
            }
        }

        for (Map.Entry str : mapEmailToIds.entrySet()) {

        }


        return result;
    }

    public static List<String> combineEmail(List<Integer> indexes, List<List<String>> accounts) {
        List<String> result = new ArrayList<>();
        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < indexes.size(); i++) {
            for (int j = 1; j < accounts.get(indexes.get(i)).size(); j++) {
                set.add(accounts.get(indexes.get(i)).get(j));
            }
        }
        result.add(accounts.get(indexes.get(0)).get(0));
        List<String> sortedBefore = set.stream().collect(Collectors.toList());
        Collections.sort(sortedBefore);
        result.addAll(sortedBefore);
        return result;
    }
}
