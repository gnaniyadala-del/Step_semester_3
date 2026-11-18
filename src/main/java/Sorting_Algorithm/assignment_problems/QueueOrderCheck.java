package main.java.Sorting_Algorithm.assignment_problems;

public class QueueOrderCheck {
    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        // Scan from index 1 and compare each token with the previous one
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        System.out.println(firstBreak(tokens1)); // Expected: 4

        // Sample Input 2
        int[] tokens2 = {1, 2, 2, 7};
        System.out.println(firstBreak(tokens2)); // Expected: -1

        // Custom Test Case (Empty and single-element queues)
        System.out.println(firstBreak(new int[]{}));   // Expected: -1
        System.out.println(firstBreak(new int[]{42})); // Expected: -1
    }
}
