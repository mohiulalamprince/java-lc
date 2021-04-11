public class ValidNumber {
    public static void main(String args[]) {

    }

    public boolean isNumber(String s) {
        int i = 0;

        for (i = 0; i < s.length(); i++) {

        }
        return false;
    }

    public boolean isAllDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
