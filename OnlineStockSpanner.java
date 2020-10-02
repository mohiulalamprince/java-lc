import java.util.Stack;

public class OnlineStockSpanner {
    public OnlineStockSpanner() {

    }

    Stack<Integer> prices = new Stack<>();
    Stack<Integer> weights = new Stack<>();
    public int next(int price) {
        int cost = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            cost += weights.pop();
        }
        prices.push(price);
        weights.push(cost);

        return cost;
    }

    public static void main(String args[]) {

    }
}
