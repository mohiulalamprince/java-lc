import java.util.Collections;
import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
    public static void main(String args[]) {
        //System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        //System.out.println(minRemoveToMakeValid("a)b(c)d"));
        //System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }

    public static String minRemoveToMakeValid(String s) {
        String str = "";
        Stack<Character> stack = new Stack<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            if (start == 0 && s.charAt(i) == ')') {
                continue;
            } else {
                stack.push(s.charAt(i));
                if (s.charAt(i) == '(') start ++;
                if (s.charAt(i) == ')') start --;
            }
        }
        String append = "";
        if (start != 0) {
            while (!stack.empty() && start > 0) {
                char c = stack.peek();
                if (c == '(') {
                    stack.pop();
                    start --;
                } else {
                    stack.pop();
                    append += c;
                }
            }
        }
        StringBuilder sb = new StringBuilder(append);
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            stack.push(sb.charAt(i));
        }

        sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
