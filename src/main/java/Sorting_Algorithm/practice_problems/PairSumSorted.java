package main.java.Sorting_Algorithm.assignment_problems;

public class PairSumSorted {
    // Returns a 2-element array [val1, val2] if found, or null if no pair exists
    public static int[] pairSumSorted(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int currentSum = nums[left] + nums[right];

            if (currentSum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result1 = pairSumSorted(new int[]{-4, -1, 0, 3, 5, 9}, 4);
        System.out.println(result1 != null ? "(" + result1[0] + ", " + result1[1] + ")" : "Not Found"); // (-1, 5)

        int[] result2 = pairSumSorted(new int[]{1, 2, 3}, 100);
        System.out.println(result2 != null ? "(" + result2[0] + ", " + result2[1] + ")" : "Not Found"); // Not Found
    }
}
