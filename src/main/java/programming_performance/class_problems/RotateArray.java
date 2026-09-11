package programming_performance.class_problems;


    import java.util.Arrays;

    public class RotateArray {
        public static int[] rotateArray(int[] nums, int k) {
            if (nums == null || nums.length == 0) return nums;

            int n = nums.length;

            k = k % n;


            int[] newArray = new int[n];


            for (int i = 0; i < n; i++) {
                newArray[(i + k) % n] = nums[i];
            }

            return newArray;
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 4, 5, 6, 7};
            int k = 3;
            int[] rotated = rotateArray(nums, k);
            System.out.println(Arrays.toString(rotated));
        }
    }


