import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public boolean solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i] - 1) || map.containsKey(A[i] + 1)) {
                return true;
            }
            map.put(A[i], true);
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(solution(-999));
        System.out.println(solution(268));
        System.out.println(solution(0));
        System.out.println(solution(670));
        System.out.println(solution(-1));
        System.out.println(solution(-14));

    }

    public static int solution(int N) {
        boolean neg = false;
        if (N < 0) {
            neg = true;
            N = -N;
        }

        String s = String.valueOf(N);

        int targetValue = neg ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        for (int i = 0; i <= s.length(); i++) {
            String genValueStr = s.substring(0, i) + "5" + s.substring(i, s.length());

            int genValueInt = Integer.parseInt(genValueStr);

            targetValue = neg ? Math.min(targetValue, genValueInt) : Math.max(targetValue, genValueInt);
        }

        if (neg) return -targetValue;
        return targetValue;
    }
}
