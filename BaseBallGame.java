import java.util.ArrayDeque;

public class BaseBallGame {
    public static void main(String args[]) {
        System.out.println(calPoints(new String[] {"5", "2", "C", "D", "+"}));
    }

    static int calPoints(String[] ops) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.add(Integer.parseInt(ops[0]));
        for (int i = 1; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                deque.removeLast();
            } else if (ops[i].equals("+")) {
                int x = deque.getLast();
                deque.removeLast();

                int y = deque.getLast();
                deque.removeLast();

                deque.addLast(y);
                deque.addLast(x);

                deque.addLast(x + y);
            } else if (ops[i].equals("D")) {
                int x = deque.getLast();
                deque.addLast(2 * x);
            } else {
                deque.add(Integer.parseInt(ops[i]));
            }
        }

        int sum = 0;
        while (!deque.isEmpty()) {
            sum += deque.peekFirst();
            deque.removeFirst();

        }
        return sum;
    }
}
