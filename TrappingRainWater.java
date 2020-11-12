import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class TrappingRainWater {

    public static int trap(int[] height) {
        if (height.length == 0 || height.length <= 2) return 0;

        int result = 0;
        Stack<Integer> stack = new Stack<>();

        stack.add(0);
        int current = 1;
        while (current < height.length) {

            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.peek();
                stack.pop();

                int distance = 0;
                if (!stack.isEmpty()) {
                    distance = (current - stack.peek()) - 1;
                } else {
                    break;
                }

                result += distance * ((Math.min(height[current], height[stack.peek()])) - height[top]);
            }
            stack.add(current++);
        }
        return result;
    }

    public static void main(String args[]) {
        int input[] = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //System.out.println(trap(input));

        int input2[] = new int[] {4, 2, 0, 3, 2, 5};
        System.out.println(trap(input2));
    }
}
