public class LongestPalindromeSubstring {

    static String subString = "";
    public static void main (String args[]) {
        String result = longestPalindrome("babad");
        System.out.println(result);
    }

    static String longestPalindrome(String s) {
        String best = "";
        for (int i = 0; i < s.length(); i++) {


            subString = "";
            boolean x = isPalindrome(i, i, s);
            if (best.length() < subString.length()) {
                best = subString;
            }

            subString = "";
            boolean y = isPalindrome(i, i + 1, s);
            if (best.length() < subString.length()) {
                best = subString;
            }
        }
        return best;
    }

    public static boolean isPalindrome(int start, int end, String s) {

        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                subString = s.substring(start, end  +1);
                start --;
                end++;
            } else {
                return false;
            }
        }

        return true;
    }
}
