import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class TrappingRainWater {
    public static void main(String args[]) {
        Consumer<Integer> out = System.out::println;
        //out.accept(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        //out.accept(trap(new int[]{0, 1, 0, 2}));
        //out.accept(trap(new int[]{0, 1, 0}));
        out.accept(trap(new int[]{2, 0, 2}));
    }

    public static int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max)
                    left_max = height[left];
                else
                    result += left_max - height[left];
                left++;
            } else {
                if (height[right] >= right_max)
                    right_max = height[right];
                else
                    result += right_max - height[right];
                right--;
            }
        }
        return result;
    }

    public static void exp() {
        int input[] = new int[] {2, 4, 1, 6, 3, 5, 9};

        OptionalInt maxValue = Arrays.stream(input).max();

    }
}
