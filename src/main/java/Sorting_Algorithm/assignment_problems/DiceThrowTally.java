package main.java.Sorting_Algorithm.assignment_problems;

import java.util.Arrays;

public class DiceThrowTally {
    public static int[] diceSort(int[] rolls) {
        if (rolls == null) {
            return new int[0];
        }

        // Count occurrences of each die value (1 through 6)
        int[] count = new int[7];
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                count[roll]++;
            }
        }

        // Print the counts in the requested format
        StringBuilder countOutput = new StringBuilder("Counts:");
        for (int v = 1; v <= 6; v++) {
            countOutput.append(" ").append(v).append(":").append(count[v]);
        }
        System.out.println(countOutput);

        // Build the sorted result array using the counts
        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        // Sample Input
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        int[] sorted1 = diceSort(rolls1);
        System.out.println("Sorted: " + Arrays.toString(sorted1));

        // Custom Test Case
        System.out.println();
        int[] rolls2 = {6, 5, 6, 2, 3, 2, 6};
        int[] sorted2 = diceSort(rolls2);
        System.out.println("Sorted: " + Arrays.toString(sorted2));
    }
}
