import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String args[]) {
        solution("  root r-x delete-this.xls\n  root r-- bug-report.pdf\n  root r-- doc.xls\n  root r-- podcast.flac\n alice r-- system.xls\n  root --x invoices.pdf\n admin rwx SETUP.PY")
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

        return new String("NO FILES");
    }
}
