import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class UniqueMaxLength {
    public static void main(String args[]) {
        List<String> result = findStringByMaxLength(Arrays.asList("one", "two", "three"),
                Arrays.asList("one", "two", "five", "six"),
                Arrays.asList("two", "five"));
        result.forEach(System.out::println);

        /*for (int i = 0; i < 20; i++) res[i] = -1;
        System.out.println(findFibonacy(3));*/
    }

    public static List<String> findStringByMaxLength(List<String> original, List<String> add, List<String> remove) {
        Map<String, Boolean> map = new HashMap<>();
        original = Stream.concat(original.stream(), add.stream()).collect(Collectors.toList());
        original.stream().map(item -> map.put(item, true)).collect(Collectors.toSet());

        for (int i = 0; i < remove.size(); i++) {
            if (map.containsKey(remove.get(i))) {
                map.remove(remove.get(i));
            }
        }

        List<String> keys = new ArrayList<>(map.keySet());
        return keys.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
    }

    static long res[] = new long[20];
    public static long findFibonacy(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (res[n] != -1) return res[n];

        res[n] = findFibonacy(n - 1) + findFibonacy(n - 2);
        return res[n];
    }
}
