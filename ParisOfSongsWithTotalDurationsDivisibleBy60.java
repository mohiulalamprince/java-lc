public class ParisOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int rem[] = new int[60];

        int counter = 0;

        for (int t : time) {
            if (t % 60 == 0) {
                counter += rem[ t % 60];
            } else {
                counter += rem[60 - (t % 60)];
            }
            rem[t % 60]++;
        }
        return counter;
    }
}
