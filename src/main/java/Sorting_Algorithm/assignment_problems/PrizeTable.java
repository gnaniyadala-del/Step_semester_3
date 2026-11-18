package main.java.Sorting_Algorithm.assignment_problems;

import java.util.Arrays;

public class PrizeTable {
    public static int prizeTable(int[] marks) {
        if (marks == null || marks.length <= 1) {
            return 0;
        }

        int n = marks.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            // Find the largest mark among the remaining unsorted elements
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap only if the largest mark is not already at position i
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] marks1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(marks1);
        System.out.println(Arrays.toString(marks1) + " swaps = " + swaps1); // [90, 75, 60, 45] swaps = 2

        int[] marks2 = {80, 70, 60};
        int swaps2 = prizeTable(marks2);
        System.out.println(Arrays.toString(marks2) + " swaps = " + swaps2); // [80, 70, 60] swaps = 0

        // Custom Test Case (Reverse sorted input)
        int[] marks3 = {50, 65, 85, 95};
        int swaps3 = prizeTable(marks3);
        System.out.println(Arrays.toString(marks3) + " swaps = " + swaps3); // [95, 85, 65, 50] swaps = 2
    }
}
