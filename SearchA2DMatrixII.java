import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchA2DMatrixII {
    boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int index = Collections.binarySearch(Arrays.stream(matrix[i]).boxed().collect(Collectors.toList()), target);

            if (index >= 0) {
                return true;
            }
        }
        return false;
    }
}
