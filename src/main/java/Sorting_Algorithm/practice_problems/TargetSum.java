package main.java.Sorting_Algorithm.assignment_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TargetSum {
    // Approach 1: Hash Set - O(n) time, O(n) space
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    // Approach 2: Sorting + Two Pointers - O(n log n) time, O(1) auxiliary space
    public static boolean hasPairWithSumTwoPointers(int[] nums, int target) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int left = 0;
        int right = copy.length - 1;

        while (left < right) {
            int sum = copy[left] + copy[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9)); // true
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));     // false
        System.out.println(hasPairWithSumTwoPointers(new int[]{2, 7, 11, 15}, 9)); // true
    }
}
