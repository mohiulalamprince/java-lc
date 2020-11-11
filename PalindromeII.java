public class PalindromeII {
    public static void main(String args[]) {

    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isOk(left + 1, right, s)) return true;
                else if (isOk(left, right - 1, s)) return true;
                else return false;
            } else {
                left ++;
                right--;
            }
        }

        return true;
    }

    public static boolean isOk(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right) ) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
