public class MedianOfTwoSortedArrays {
    public static void main(String args[]) {
        //System.out.println(findMedianSortedArrays(new int[]{1, 4, 5, 6, 9, 10, 14, 16},
        //        new int[]{2, 3, 7, 8, 11, 12, 13, 15, 17}));
        //System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[] {3, 4}));
        //System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int input1[], int input2[]) {
        int left = 0;
        int right = input1.length;

        if (input1.length > input2.length)
            return findMedianSortedArrays(input2, input1);

        int x = input1.length;
        int y = input2.length;
        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = ((x + y + 1) / 2) - partitionA;

            int maxLeftX = (partitionA == 0) ? Integer.MIN_VALUE : input1[partitionA - 1];
            int maxLeftY = (partitionB == 0) ? Integer.MIN_VALUE : input2[partitionB - 1];

            int minRightX = (partitionA == x) ? Integer.MAX_VALUE : input1[partitionA];
            int minRightY = (partitionB == y) ? Integer.MAX_VALUE : input2[partitionB];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }

        return 0;
    }
}
