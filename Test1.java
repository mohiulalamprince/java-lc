import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
    static int[] visit;
    static int counter = 0;
    /*
     * Complete the 'connectedSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY edges
     */

    static void dfs(int x, List<List<Integer>> graph) {
        for (int i = 0; i < graph.get(x).size(); i++) {
            int node = graph.get(x).get(i);
            if (visit[node] == 0) {
                visit[node] = 1;
                counter++;
                dfs(node, graph);
            }
        }
    }

    public static int connectedSum(int n, List<String> edges) {
        visit = new int[n+1];
        int result = 0;
        List<List<Integer>> graph = new ArrayList<>();
        graph.clear();
        counter = 0;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (String edge : edges) {
            String[] parts = edge.split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            List<Integer> edgesList = graph.get(x);
            edgesList.add(y);
            graph.set(x, edgesList);

            List<Integer> edgesList2 = graph.get(y);
            edgesList2.add(x);
            graph.set(y, edgesList2);
        }
        for (int i = 1; i <= n; i++) {
            counter = 0;
            if (visit[i] == 0) {
                visit[i] = 1;
                counter = 1;
                dfs(i, graph);
                result += Math.ceil(Math.sqrt((double)counter));
            }
        }

        return result;
    }

    public static void main(String args[]) {
        //int x=connectedSum(4, new ArrayList<String>(Arrays.asList("1 2", "1 4")));
        //int x=connectedSum(8, new ArrayList<String>(Arrays.asList("8 1", "5 8", "7 3", "8 6")));
        int x=connectedSum(10, new ArrayList<String>(Arrays.asList("1 2", "1 3", "2 4", "3 5", "7 8")));
        System.out.println(x);
    }
}
