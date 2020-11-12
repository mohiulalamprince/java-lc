import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CriticalConnectionsInANetwork {
    public static void main(String args[]) {
        criticalConnections(10, null);
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> in = IntStream.range(0, 100).map(i -> Integer.MAX_VALUE).boxed().collect(Collectors.toList());

        return result;
    }
}
