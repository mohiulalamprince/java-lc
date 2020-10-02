import java.util.List;
import java.util.stream.*;
import java.util.ArrayList;


class PartitionLabels {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++)
            last[S.charAt(i) - 'a'] = i;

        int start_position = 0;
        int max_position = 0;

        for (int i = 0; i < S.length(); i++) {
            max_position = Math.max(max_position, last[S.charAt(i) - 'a']);
            if (max_position == i) {
                result.add(max_position - start_position + 1);
                start_position = i + 1;
            }
        }
        return result;            
    }

    public static void main(String args[]) {
        List<Integer> result = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(result);
    }
}
