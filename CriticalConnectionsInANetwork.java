import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CriticalConnectionsInANetwork {
    public static void main(String args[]) {
        criticalConnections(10, null);
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < connections.size(); i++) {
            List<List<Integer>> a = connections.subList(0, i);
            List<List<Integer>> b = connections.subList(i + 1, connections.size());
            b.addAll(a);
            if (!connected(n, b)) {
                result.add(connections.get(i));
            }
        }
        return result;
    }

    public static boolean connected(int n, List<List<Integer>> conn) {
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) marks[i] = i;

        for (List<Integer> con : conn) {
            int to = con.get(0);
            int from = con.get(1);

            if (marks[to] == to && marks[from] == from) {
                marks[to] = marks[from] = Math.min(marks[to], marks[from]);
            } else {
                if (marks[to] < marks[from]) {
                    int val = marks[from];
                    for (int j = 0; j < n; j++) {
                        if (val == marks[j]) marks[j] = marks[to];
                    }
                } else {
                    int val = marks[to];
                    for (int j = 0; j < n; j++) {
                        if (val == marks[j]) marks[j] = marks[from];
                    }
                }
            }

        }

        Set<Integer> unique = Arrays.stream(marks).boxed().collect(Collectors.toSet());
        return unique.size() == 1;
    }
}
