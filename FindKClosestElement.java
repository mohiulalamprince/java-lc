import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindKClosestElement {
    public static void main(String args[]) {

    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = 0;
        List<Integer> array = Arrays.stream(arr).boxed().collect(Collectors.toList());

        if (x < array.get(0)) return array.subList(0, k);
        else if (x > array.get(array.size() - 1)) return array.subList(array.size() - k, array.size());
        else {
            int index = Collections.binarySearch(array, x);

            if (index < 0)
                index = -index - 1;
            high = Math.min(index + k -1, array.size()-1);
            low = Math.max(0, index - k -1);

            while (high - low + 1 > k) {
                if ( Math.abs(x - array.get(low)) <= Math.abs(x - array.get(high))) {
                    high--;
                } else if ( Math.abs(x - array.get(low)) > Math.abs(x - array.get(high))) {
                    low++;
                }
            }
        }
        return array.subList(low, high + 1);
    }
}
