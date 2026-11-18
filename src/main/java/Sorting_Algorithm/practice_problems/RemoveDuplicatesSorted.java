package main.java.Sorting_Algorithm.assignment_problems;

import java.util.Arrays;

public class RemoveDuplicatesSorted {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 'writeIndex' tracks the position for the next unique element
        int writeIndex = 1;

        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[readIndex - 1]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);

        System.out.println("length = " + length); // 5
        System.out.println("nums[0.." + (length - 1) + "] = " + Arrays.toString(Arrays.copyOfRange(nums, 0, length))); // [1, 2, 3, 4, 5]
    }
}
