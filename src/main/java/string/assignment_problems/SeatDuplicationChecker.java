public class SeatDuplicationChecker {

    public static void main(String[] args) {
        // Test Case 1: Has duplicates
        int[] seatNumbers1 = {101, 102, 103, 102, 105};
        System.out.println("Testing Input: {101, 102, 103, 102, 105}");
        checkDuplicateSeats(seatNumbers1);

        System.out.println("\n-------------------------------------\n");

        // Test Case 2: No duplicates
        int[] seatNumbers2 = {101, 102, 103, 104, 105};
        System.out.println("Testing Input: {101, 102, 103, 104, 105}");
        checkDuplicateSeats(seatNumbers2);
    }

    /**
     * Checks for duplicate seat numbers using nested loops without using Collections.
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        // Nested loops to compare every element with every other subsequent element
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    // Break inner loop to avoid counting the same pairing multiple times
                    break;
                }
            }
        }

        // If no duplicates were found after scanning the entire array
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}
