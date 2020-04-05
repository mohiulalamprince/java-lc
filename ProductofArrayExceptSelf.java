import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        if (nums.length == 1) return new int[]{0};
        int res[] = new int[nums.length];

        int counter =1;
        res[0] = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i--) {
            res[counter] = res[counter -1] * nums[i];
            counter ++;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = res[nums.length - 1 -i];
            res[nums.length - 1 -i] = res[i];
            res[i] = temp;
        }

        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0)
            sum *= nums[i-1];
            res[i] = getValue(i, sum, res);
        }
        return res;
    }

    public static int getValue(int index, int sum, int[] product) {
        if (index == 0) {
            if (product.length == 1)
                return 0;
            return product[index + 1];
        } else if (index == product.length -1){
            return sum;
        } else {
            return sum * product[index + 1];
        }
    }

    public static void main(String args[]) {
        int res[] = productExceptSelf(new int[]{4, 3, 2, 1, 2});
        for (int i =0 ; i < res.length; i++) System.out.println(res[i]);
    }
}
