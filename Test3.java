import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String args[]) {
    }

    public static String solution(String S) {
        // write your code in Java SE 8
        int minLen = 0;
        StringBuilder str = new StringBuilder();
        List<String> input = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '\n') {
                input.add(str.toString());
                str.setLength(0);
            } else {
                str.append(S.charAt(i));
            }
        }


        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        return new String("NO FILES");
    }
}
