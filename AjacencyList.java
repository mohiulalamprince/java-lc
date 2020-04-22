import java.util.ArrayList;
import java.util.List;

public class AjacencyList {
    public static void main(String args[]) {
        List<ArrayList<Integer>> alist = new ArrayList<>(10);

        for (int i = 0; i < 10; i++)
            alist.add(new ArrayList<>());
        alist.get(0).add(1);
        alist.get(1).add(2);
        alist.get(1).add(3);
        print(alist);
    }

    public static void print(List<ArrayList<Integer>> alist) {
        for (int i = 0; i < alist.size(); i++) {
            alist.get(i).stream().forEach(x -> System.out.print(x));
            System.out.println();
        }
    }
}
