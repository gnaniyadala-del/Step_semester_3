package main.java.Sorting_Algorithm.assignment_problems;

import java.util.Arrays;

public class HeightLineUp {
    public static void lineUp(int[] heights) {
        if (heights == null || heights.length == 0) {
            return;
        }

        int n = heights.length;

        for (int pass = 1; pass <= n; pass++) {
            boolean swapped = false;

            // Sweep from left to right, comparing adjacent elements
            for (int j = 0; j < n - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            // Print the array after every sweep
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));

            // Stop early if no swaps occurred during this sweep
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        lineUp(new int[]{4, 2, 5, 1});

        System.out.println("\n--- Test Case 2 ---");
        lineUp(new int[]{1, 3, 2, 4});
    }
}
