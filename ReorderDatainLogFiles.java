public class ReorderDatainLogFiles {
    public static void main(String args[]) {

    }

    public String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];

        

        for (int i = 0; i < logs.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(i, j, logs);
            }
        }
        return result;
    }

    public void swap(int x, int y, String[] logs) {
        String first = logs[x];
        String second = logs[y];

        if (first.substring(first.indexOf(' ')).compareTo(second.substring(second.indexOf(' '))) > 0) {
            logs[x] = second;
            logs[y] = first;
        } else if (first.substring(first.indexOf(' ')).compareTo(second.substring(second.indexOf(' '))) == 0) {
            if (first.substring(first.indexOf(' ')).compareTo(second.substring(second.indexOf(' '))) > 0) {
                logs[y] = first;
                logs[x] = second;
            }
        }
    }
}
